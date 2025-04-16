<h1 align="center">🧠 DLL Injectors Collection</h1>
<p align="center">
  <i>My Educational injector implementations written in C#, C++, and Java</i>
</p>

---

## Overview

| Language | Method         | Notes                  |
|----------|----------------|------------------------|
| C#       | `LoadLibraryA` | WinForms Console App   |
| C++      | `LoadLibraryA` | Classic native method  |
| Java     | `LoadLibraryA` | Uses JNA (Windows API) |

---

## Description

This repository serves as a **learning resource** to understand how basic DLL injection works across multiple programming languages on Windows.

Each injector uses the `OpenProcess`, `VirtualAllocEx`, `WriteProcessMemory`, and `CreateRemoteThread` technique.

> *These are clean examples built for learning, debugging, and offline dev environments and these methods of injection* **ARE DETECTED**

---

## ⓘ Information before usage

- Compatible with: 64-bit Windows systems
- Java injector requires [JNA](https://github.com/java-native-access/jna)

---

## 🛑 Disclaimer

This project is for **educational use only**.  
Do not use this code with online games, anti-cheat-protected processes, or in violation of any software’s terms of service.

---
