Name:           rname
Version:        1.0
Release:        1%{?dist}
Summary:        rname Java Application

License:        GPLv3
URL:            https://github.com/acidburnmonkey/Rname
Source0:        rname.jar
Source1:        rname

BuildArch:      noarch
BuildRequires:  java
Requires:       java >= 1.8

%description
rname is a simple file rename utility written in Java.
Rather than using the move command and having to re type the path twice. Rname renames the file or directory at its current path.

%prep

%build

%install
# Create installation directories
mkdir -p %{buildroot}/usr/share/rname
mkdir -p %{buildroot}/usr/bin

# Install the .jar file
cp %{SOURCE0} %{buildroot}/usr/share/rname/rname.jar

# Install the wrapper script
cp %{SOURCE1} %{buildroot}/usr/bin/rname
chmod +x %{buildroot}/usr/bin/rname

%files
/usr/share/rname/rname.jar
/usr/bin/rname

%doc

%changelog
* Thu Dec 08 2024  Acid - 1.0-1
- Initial package with wrapper and .jar file
