Name:           rname
Version:        1.0
Release:        1%{?dist}
Summary:        rname Java Application

License:        GPLv3
URL:            https://github.com/acidburnmonkey/Rname
Source0:        rname-1.0-sources.tar.gz
BuildArch:      noarch
BuildRequires:  java-21-openjdk-devel, maven
Requires:       java-21-openjdk

%description
rname is a simple file rename utility written in Java.
Rather than using the move command and having to re type the path twice. Rname renames the file or directory at its current path.

%prep
%setup -q -n rname-1.0

%build
mvn clean package

%install
mkdir -p %{buildroot}/usr/share/rname
mkdir -p %{buildroot}/usr/bin

cp target/rname-1.0.jar %{buildroot}/usr/share/rname/

# Create a wrapper script
cat > %{buildroot}/usr/bin/rname << 'EOF'
#!/bin/bash
java -jar /usr/share/rname/rname-1.0.jar "$@"
EOF
chmod +x %{buildroot}/usr/bin/rname

%files
/usr/share/rname/rname-1.0.jar
/usr/bin/rname

%doc
%changelog
* Thu Dec 08 2024  Acid - 1.0-1
- Build and package the .jar file using Maven
