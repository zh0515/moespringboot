lowercasename=$(echo ${1}| tr '[A-Z]'  '[a-z]')
echo ${lowercasename}
echo will make file:src/cn/gov/gdupi/model/${1}.java
cp src/cn/gov/gdupi/model/Base.java src/cn/gov/gdupi/model/${1}.java
sed -i "s/Base/${1}/g" src/cn/gov/gdupi/model/${1}.java
sed -i "s/base/${lowercasename}/g" src/cn/gov/gdupi/model/${1}.java

echo will make file:src/cn/gov/gdupi/controller/${1}Controller.java
cp src/cn/gov/gdupi/controller/BaseController.java src/cn/gov/gdupi/controller/${1}Controller.java
sed -i "s/Base/${1}/g" src/cn/gov/gdupi/controller/${1}Controller.java
sed -i "s/base/${lowercasename}/g" src/cn/gov/gdupi/controller/${1}Controller.java


echo will make file:src/cn/gov/gdupi/dao/read/R${1}Mapper.java
cp src/cn/gov/gdupi/dao/read/RBaseMapper.java src/cn/gov/gdupi/dao/read/R${1}Mapper.java
sed -i "s/Base/${1}/g" src/cn/gov/gdupi/dao/read/R${1}Mapper.java
sed -i "s/base/${lowercasename}/g" src/cn/gov/gdupi/dao/read/R${1}Mapper.java

echo will make file:src/cn/gov/gdupi/dao/write/W${1}Mapper.java
cp src/cn/gov/gdupi/dao/write/WBaseMapper.java src/cn/gov/gdupi/dao/write/W${1}Mapper.java
sed -i "s/Base/${1}/g" src/cn/gov/gdupi/dao/write/W${1}Mapper.java
sed -i "s/base/${lowercasename}/g" src/cn/gov/gdupi/dao/write/W${1}Mapper.java


echo will make file:resources/mybatis/read/R${1}Mapper.xml
cp resources/mybatis/read/RBaseMapper.xml resources/mybatis/read/R${1}Mapper.xml
sed -i "s/Base/${1}/g" resources/mybatis/read/R${1}Mapper.xml
sed -i "s/base/${lowercasename}/g" resources/mybatis/read/R${1}Mapper.xml

echo will make file:resources/mybatis/write/W${1}Mapper.xml
cp resources/mybatis/write/WBaseMapper.xml resources/mybatis/write/W${1}Mapper.xml
sed -i "s/Base/${1}/g" resources/mybatis/write/W${1}Mapper.xml
sed -i "s/base/${lowercasename}/g" resources/mybatis/write/W${1}Mapper.xml


echo will make file:src/cn/gov/gdupi/service/${1}Service.java
cp src/cn/gov/gdupi/service/BaseService.java src/cn/gov/gdupi/service/${1}Service.java
sed -i "s/Base/${1}/g" src/cn/gov/gdupi/service/${1}Service.java
sed -i "s/base/${lowercasename}/g" src/cn/gov/gdupi/service/${1}Service.java
