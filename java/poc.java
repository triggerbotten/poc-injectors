import com.sun.jna.*;
import com.sun.jna.ptr.*;

public class JavaInjector {

    public interface Kernel32 extends Library {
        Kernel32 INSTANCE = Native.load("kernel32", Kernel32.class);

        Pointer OpenProcess(int dwDesiredAccess, boolean bInheritHandle, int dwProcessId);
        Pointer VirtualAllocEx(Pointer hProcess, Pointer lpAddress, int dwSize, int flAllocationType, int flProtect);
        boolean WriteProcessMemory(Pointer hProcess, Pointer lpBaseAddress, byte[] lpBuffer, int nSize, IntByReference lpNumberOfBytesWritten);
        Pointer GetProcAddress(Pointer hModule, String lpProcName);
        Pointer GetModuleHandle(String lpModuleName);
        Pointer CreateRemoteThread(Pointer hProcess, Pointer lpThreadAttributes, int dwStackSize,
                                   Pointer lpStartAddress, Pointer lpParameter, int dwCreationFlags, Pointer lpThreadId);
    }

    public static void main(String[] args) {
        String dllPath = "C:\\Path\\To\\Your.dll";
        int pid = 1234; // Insert process ID manually or make a function to search for the target

        int PROCESS_ALL_ACCESS = 0x1F0FFF;
        Pointer process = Kernel32.INSTANCE.OpenProcess(PROCESS_ALL_ACCESS, false, pid);

        Pointer mem = Kernel32.INSTANCE.VirtualAllocEx(process, null, dllPath.length(), 0x1000 | 0x2000, 0x40);
        IntByReference written = new IntByReference(0);
        Kernel32.INSTANCE.WriteProcessMemory(process, mem, dllPath.getBytes(), dllPath.length(), written);

        Pointer loadLib = Kernel32.INSTANCE.GetProcAddress(Kernel32.INSTANCE.GetModuleHandle("kernel32.dll"), "LoadLibraryA");
        Kernel32.INSTANCE.CreateRemoteThread(process, null, 0, loadLib, mem, 0, null);
    }
}
