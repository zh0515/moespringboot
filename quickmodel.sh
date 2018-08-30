lowercasename=$(echo ${1}| tr '[A-Z]'  '[a-z]')
echo ${lowercasename}
echo will make file:src/main/java/cn/gov/gdupi/model/${1}.java
cp src/main/java/cn/gov/gdupi/model/Base.java src/main/java/cn/gov/gdupi/model/${1}.java
sed -i "s/Base/${1}/g" src/main/java/cn/gov/gdupi/model/${1}.java
sed -i "s/base/${lowercasename}/g" src/main/java/cn/gov/gdupi/model/${1}.java

echo will make file:src/main/java/cn/gov/gdupi/controller/${1}Controller.java
cp src/main/java/cn/gov/gdupi/controller/BaseController.java src/main/java/cn/gov/gdupi/controller/${1}Controller.java
sed -i "s/Base/${1}/g" src/main/java/cn/gov/gdupi/controller/${1}Controller.java
sed -i "s/base/${lowercasename}/g" src/main/java/cn/gov/gdupi/controller/${1}Controller.java


echo will make file:src/main/java/cn/gov/gdupi/dao/read/R${1}Mapper.java
cp src/main/java/cn/gov/gdupi/dao/read/RBaseMapper.java src/main/java/cn/gov/gdupi/dao/read/R${1}Mapper.java
sed -i "s/Base/${1}/g" src/main/java/cn/gov/gdupi/dao/read/R${1}Mapper.java
sed -i "s/base/${lowercasename}/g" src/main/java/cn/gov/gdupi/dao/read/R${1}Mapper.java

echo will make file:src/main/java/cn/gov/gdupi/dao/write/W${1}Mapper.java
cp src/main/java/cn/gov/gdupi/dao/write/WBaseMapper.java src/main/java/cn/gov/gdupi/dao/write/W${1}Mapper.java
sed -i "s/Base/${1}/g" src/main/java/cn/gov/gdupi/dao/write/W${1}Mapper.java
sed -i "s/base/${lowercasename}/g" src/main/java/cn/gov/gdupi/dao/write/W${1}Mapper.java


echo will make file:src/main/resources/cn/gov/gdupi/dao/read/R${1}Mapper.xml
cp src/main/resources/cn/gov/gdupi/dao/read/RBaseMapper.xml src/main/resources/cn/gov/gdupi/dao/read/R${1}Mapper.xml
sed -i "s/Base/${1}/g" src/main/resources/cn/gov/gdupi/dao/read/R${1}Mapper.xml
sed -i "s/base/${lowercasename}/g" src/main/resources/cn/gov/gdupi/dao/read/R${1}Mapper.xml

echo will make file:src/main/resources/cn/gov/gdupi/dao/write/W${1}Mapper.xml
cp src/main/resources/cn/gov/gdupi/dao/write/WBaseMapper.xml src/main/resources/cn/gov/gdupi/dao/write/W${1}Mapper.xml
sed -i "s/Base/${1}/g" src/main/resources/cn/gov/gdupi/dao/write/W${1}Mapper.xml
sed -i "s/base/${lowercasename}/g" src/main/resources/cn/gov/gdupi/dao/write/W${1}Mapper.xml


echo will make file:src/main/java/cn/gov/gdupi/service/${1}Service.java
cp src/main/java/cn/gov/gdupi/service/BaseService.java src/main/java/cn/gov/gdupi/service/${1}Service.java
sed -i "s/Base/${1}/g" src/main/java/cn/gov/gdupi/service/${1}Service.java
sed -i "s/base/${lowercasename}/g" src/main/java/cn/gov/gdupi/service/${1}Service.java
