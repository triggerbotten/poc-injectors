# C++ DLL Injector

A lightweight and fast DLL injector built with C++ for educational learning purposes.

## Features
- Process snapshot using `CreateToolhelp32Snapshot`
- Injects via `LoadLibraryA` method
- Uses `CreateRemoteThread` for execution

## Usage
1. Build with Visual Studio (x86 or x64 based on target).
2. Change the path to your DLL and the target process name inside the source.
3. Run as administrator for better compatibility.

## 📎 Disclaimer
Made for debugging, learning, and offline use.  
Not intended for use with anti-cheat-protected applications.

---

