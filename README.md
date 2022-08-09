# JEC-kt

[![GitHub Actions status](https://github.com/jabacat/JEC-kt/actions/workflows/gradle.yml/badge.svg)](https://github.com/jabacat/JEC-kt/actions)

Jabacat's Easy Config

[JEC-py](https://github.com/jabacat/JEC-py) | [JEC-rs](https://github.com/jabacat/JEC-rs) | [JEC-go](https://github.com/jabacat/JEC-go) | JEC-c | [JEC-c++](https://github.com/jabacat/JEC-cpp) | JEC-zig | JEC-ts | [JEC-kt](https://github.com/jabacat/JEC-kt)

## API

```text
ConfigFile
  - exists
  - remove
  - create
  - fromHome
  
ConfigDir
  - exists
  - remove
  - create
  - fromHome
```

## Usage

```kt
val conf1 = ConfigFile("config.yml")
val conf2 = ConfigFile.fromHome("config.yml")

val dir1 = ConfigDir("config")
val dir2 = ConfigDir.fromHome("config")

if (!dir1.exists()) dir1.create()

dir1.remove()
```
