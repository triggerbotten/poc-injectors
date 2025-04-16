# Java DLL Injector (JNA)

An experimental POC DLL injector written in Java using the JNA library to access Windows API functions.

## Dependencies
- Java 8+
- JNA (Java Native Access)

## Features
- Basic LoadLibrary injection through `CreateRemoteThread`
- Accesses Windows APIs from Java via JNA

## Usage
1. Add JNA to your project (`jna.jar`)
2. Replace the process ID and DLL path in the source
3. Run the injector with elevated privileges

## Disclaimer
This injector is for educational and experimental use only and may **not always work**.  
You must not use this with protected software or services.

---

