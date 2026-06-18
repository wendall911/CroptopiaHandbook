# CroptopiaHandbook — Project Context

## What This Is
An in-game guidebook for the [Croptopia](https://modrinth.com/mod/croptopia) mod, built using the Handbook library. Provides an up-to-date reference for Croptopia recipes, crops, and trees. No external dependencies bundled — all content is in the mod itself.

License: MIT

## Project Structure
Multi-loader: `Common/` + `NeoForge/` + `Fabric/`

## Branch Convention
| Branch | Modloaders        |
|--------|-------------------|
| 26.1   | NeoForge + Fabric |

Maintained: 26.1

## Dependencies
- Handbook (jarJar/include) — in-game guidebook library
- WhiteNoise (jarJar/include)
- Croptopia (required at runtime — this mod is a companion for it)

## Distribution
Side: both (clientRequired = true, serverRequired = true)

## Release Process
Follow the standard wendall911 release process in `../docs/minecraft/MINECRAFT_DEVELOPMENT_NOTES.md`.
