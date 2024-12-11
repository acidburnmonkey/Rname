#!/bin/bash

mkdir /usr/share/rname/
cp ./out/artifacts/rname_jar/rname.jar /usr/share/rname/
chmod +x /usr/share/rname/rname.jar

# Create a wrapper script
cat > /usr/bin/rname<< 'EOF'
#!/bin/bash
java -jar /usr/share/rname/rname.jar "$@"
EOF
chmod +x /usr/bin/rname

