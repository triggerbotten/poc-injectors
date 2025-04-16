#include <windows.h>
#include <tlhelp32.h>
#include <iostream>

DWORD GetProcID(const char* procName)
{
    DWORD procId = 0;
    HANDLE snap = CreateToolhelp32Snapshot(TH32CS_SNAPPROCESS, 0);
    PROCESSENTRY32 pe;
    pe.dwSize = sizeof(pe);

    if (Process32First(snap, &pe))
    {
        do {
            if (!_stricmp(pe.szExeFile, procName))
            {
                procId = pe.th32ProcessID;
                break;
            }
        } while (Process32Next(snap, &pe));
    }

    CloseHandle(snap);
    return procId;
}

int main()
{
    const char* dllPath = "C:\\Path\\To\\Your.dll";
    DWORD pid = GetProcID("Target.exe");

    HANDLE hProcess = OpenProcess(PROCESS_ALL_ACCESS, FALSE, pid);
    void* alloc = VirtualAllocEx(hProcess, nullptr, strlen(dllPath) + 1, MEM_COMMIT | MEM_RESERVE, PAGE_READWRITE);

    WriteProcessMemory(hProcess, alloc, dllPath, strlen(dllPath) + 1, nullptr);

    HANDLE thread = CreateRemoteThread(hProcess, nullptr, 0,
        (LPTHREAD_START_ROUTINE)GetProcAddress(GetModuleHandle("kernel32.dll"), "LoadLibraryA"),
        alloc, 0, nullptr);

    WaitForSingleObject(thread, INFINITE);
    CloseHandle(hProcess);
}
