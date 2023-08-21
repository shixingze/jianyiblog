echo '-------------------------'
echo '--------清理开始----------'
echo '-------------------------'
mvn clean
echo '-------------------------'
echo '--------打包开始----------'
echo '-------------------------'
mvn  package -DskipTests -Ptest
echo '-------------------------'
echo '--------打包结束----------'
echo '-------------------------'

echo '--------服务名称-----------'
server_name=gw
echo $server_name

server_path=/home/$server_name
echo '--------服务目录-----------'
echo $server_path


echo '--------jar包传送-----------'
cd jianyi-api/target
current=`date "+%Y-%m-%d.%H%M%S"`
mv 2023-06-08.151720.jar $current.jar
server_ip=43.143.173.212
echo '--------传送文件-----------'
scp $current.jar root@$server_ip:$server_path/$current.jar
echo '--------备份服务-----------'
ssh root@$server_ip "cd $server_path && cp $current.jar server.history"
ssh root@$server_ip "cd $server_path && mv $current.jar $server_name.jar"
echo '--------停止服务-----------'
ssh root@$server_ip "cd $server_path && docker-compose stop $server_name"
echo '--------重建镜像-----------'
ssh root@$server_ip "cd $server_path && docker-compose rm -f $server_name && docker rmi $server_name"
echo '--------启动服务-----------'
ssh root@$server_ip "cd $server_path && docker-compose up  $server_name -d && docker-compose logs -f --tail=10 $server_name"
