Name:           rname
Version:        2.1
Release:        1%{?dist}
Summary:        A bulk file renaming utility

License:        GPLv3
URL:            https://github.com/acidburnmonkey/Rname
Source0:        rname-%{version}.tar.gz

BuildRequires:  golang >= 1.19

%description
rname is a simple file rename utility written in Go. Rather than using the
move command and having to re type the path twice. Rname renames the file
or directory at its current path.

%prep
%setup -q -c -n rname-%{version}

%build
go build -o rname main.go

%install
install -Dm755 rname %{buildroot}%{_bindir}/rname

%files
%{_bindir}/rname
%license LICENSE

%changelog
* Wed Dec 11 2024 acidburnmonkey <acidburnmonkey@proton.me> - 2.1.7-1
- minor addition to help()
