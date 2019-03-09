lowercasename=$(echo ${1}| tr '[A-Z]'  '[a-z]')
echo ${lowercasename}
echo will make file:src/main/java/cn/dev/model/${1}.java
cp src/main/java/cn/dev/model/Base.java src/main/java/cn/dev/model/${1}.java
sed -i "s/Base/${1}/g" src/main/java/cn/dev/model/${1}.java
sed -i "s/base/${lowercasename}/g" src/main/java/cn/dev/model/${1}.java

echo will make file:src/main/java/cn/dev/controller/${1}Controller.java
cp src/main/java/cn/dev/controller/BaseController.java src/main/java/cn/dev/controller/${1}Controller.java
sed -i "s/Base/${1}/g" src/main/java/cn/dev/controller/${1}Controller.java
sed -i "s/base/${lowercasename}/g" src/main/java/cn/dev/controller/${1}Controller.java


echo will make file:src/main/java/cn/dev/dao/${1}Mapper.java
cp src/main/java/cn/dev/dao/BaseMapper.java src/main/java/cn/dev/dao/${1}Mapper.java
sed -i "s/Base/${1}/g" src/main/java/cn/dev/dao/${1}Mapper.java
sed -i "s/base/${lowercasename}/g" src/main/java/cn/dev/dao/${1}Mapper.java



echo will make file:src/main/resources/cn/dev/dao/${1}Mapper.xml
cp src/main/resources/cn/dev/dao/BaseMapper.xml src/main/resources/cn/dev/dao/${1}Mapper.xml
sed -i "s/Base/${1}/g" src/main/resources/cn/dev/dao/${1}Mapper.xml
sed -i "s/base/${lowercasename}/g" src/main/resources/cn/dev/dao/${1}Mapper.xml



echo will make file:src/main/java/cn/dev/service/${1}Service.java
cp src/main/java/cn/dev/service/BaseService.java src/main/java/cn/dev/service/${1}Service.java
sed -i "s/Base/${1}/g" src/main/java/cn/dev/service/${1}Service.java
sed -i "s/base/${lowercasename}/g" src/main/java/cn/dev/service/${1}Service.java
