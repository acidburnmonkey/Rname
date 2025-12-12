# Rname

Simple file rename utility written in Go. <br>
Rather than using the move command and having to re type the path twice. Rname renames the file or directory at its current path.
There is a Java implementation on other branch

## Usage

```
rname /path/to/file newName

rname thisfile newName
```

For verbose confirmation

```
rname -v /path/to/file newName
```

## Note

It will ask to overwrite if the file already exist, but It won't overwrite a directory that is not empty.

# Installation

### Fedora

```
sudo dnf copr enable acidburnmonkey/rname
sudo dnf install rname
```

## Manual ; for Ubuntu and Debian

```
sudo curl -L "https://github.com/acidburnmonkey/Rname/releases/download/v2.0/rname" -o /usr/bin/rname
sudo chmod +x /usr/bin/rname
```

### Dependencies

## Build from source

```
go build -o rname main.go
```

Then move the binary to path

<br>
<br>

## Dono Links

<a href="https://www.buymeacoffee.com/acidburn" target="_blank"><img src="https://cdn.buymeacoffee.com/buttons/default-orange.png" alt="Buy Me A Coffee" height="41" width="174"></a>

## Monero <img src="https://www.getmonero.org/press-kit/symbols/monero-symbol-1280.png" width="60" height="60">

43Sxiso2FHsYhP7HTqZgsXa3m3uHtxHQdMeHxECqRefyazZfpGVCLVsf1gU68jxJBo1G171AC181q1BqAUaG1m554MLsspG

## Bitcon <img src="https://upload.wikimedia.org/wikipedia/commons/4/46/Bitcoin.svg" width="60" height="60">

bc1qk06cyheffclx7x434zpxjzcdl50452r9ducw0x
