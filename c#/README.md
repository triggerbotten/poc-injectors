# C# DLL Injector

A simple DLL injector written in C# for educational and development testing purposes.  
Uses `OpenProcess`, `VirtualAllocEx`, and `CreateRemoteThread` to inject a DLL into a running process.

## Features
- LoadLibraryA injection
- Basic memory allocation and writing
- Target process by name

## How to Use
1. Build the project.
2. Place your target DLL on disk (e.g., `C:\Path\To\Your.dll`)
3. Update the path and process name in the code.
4. Run the executable.

## 📌 Notes
This is for educational use and debugging scenarios only.  
Do not use against protected or online games/services.

---

