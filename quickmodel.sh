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


echo will make file:src/cn/gov/gdupi/dao/read/${1}Mapper.java
cp src/cn/gov/gdupi/dao/read/BaseMapper.java src/cn/gov/gdupi/dao/read/${1}Mapper.java
sed -i "s/Base/${1}/g" src/cn/gov/gdupi/dao/read/${1}Mapper.java
sed -i "s/base/${lowercasename}/g" src/cn/gov/gdupi/dao/read/${1}Mapper.java

echo will make file:src/cn/gov/gdupi/dao/write/${1}Mapper.java
cp src/cn/gov/gdupi/dao/write/BaseMapper.java src/cn/gov/gdupi/dao/write/${1}Mapper.java
sed -i "s/Base/${1}/g" src/cn/gov/gdupi/dao/write/${1}Mapper.java
sed -i "s/base/${lowercasename}/g" src/cn/gov/gdupi/dao/write/${1}Mapper.java


echo will make file:resources/mybatis/read/${1}Mapper.xml
cp resources/mybatis/read/BaseMapper.xml resources/mybatis/read/${1}Mapper.xml
sed -i "s/Base/${1}/g" resources/mybatis/read/${1}Mapper.xml
sed -i "s/base/${lowercasename}/g" resources/mybatis/read/${1}Mapper.xml

echo will make file:resources/mybatis/write/${1}Mapper.xml
cp resources/mybatis/write/BaseMapper.xml resources/mybatis/write/${1}Mapper.xml
sed -i "s/Base/${1}/g" resources/mybatis/write/${1}Mapper.xml
sed -i "s/base/${lowercasename}/g" resources/mybatis/write/${1}Mapper.xml


echo will make file:src/cn/gov/gdupi/service/${1}Service.java
cp src/cn/gov/gdupi/service/BaseService.java src/cn/gov/gdupi/service/${1}Service.java
sed -i "s/Base/${1}/g" src/cn/gov/gdupi/service/${1}Service.java
sed -i "s/base/${lowercasename}/g" src/cn/gov/gdupi/service/${1}Service.java
