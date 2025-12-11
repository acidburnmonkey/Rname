Name:           rname
Version:        2.0
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
* Wed Dec 11 2024 acidburnmonkey <acidburnmonkey@proton.me> - 1.0.7-1
- Rewritten in Go
- Initial Go-based release

* Sun Apr 21 2024 acidburnmonkey <acidburnmonkey@proton.me> - 1.0.6-1
- fix: Handle case when config directory doesn't exist

* Sun Apr 21 2024 acidburnmonkey <acidburnmonkey@proton.me> - 1.0.5-1
- Fixed relative path issue in file tracking

* Sun Apr 21 2024 acidburnmonkey <acidburnmonkey@proton.me> - 1.0.4-1
- Fixed NullPointerException when log directory doesn't exist

* Sun Apr 21 2024 acidburnmonkey <acidburnmonkey@proton.me> - 1.0.3-1
- Fixed serialization issues with rename history

* Sat Apr 20 2024 acidburnmonkey <acidburnmonkey@proton.me> - 1.0.2-1
- Added undo functionality for renaming operations

* Sat Apr 20 2024 acidburnmonkey <acidburnmonkey@proton.me> - 1.0.1-1
- Initial release
