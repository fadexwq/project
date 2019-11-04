package cn.ego.base.utils;


import org.apache.commons.net.ftp.FTPClient;
import sun.net.ftp.impl.FtpClient;

import java.io.IOException;
import java.io.InputStream;

public class FtpUtils {

    /**
     * 实现文件上传服务端
     * @param hostname 主机名
     * @param port 端口
     * @param username 用户名
     * @param password 密码
     * @param basePath 基础路径
     * @param filePath 文件路径
     * @param remoteFileName 远程文件路径
     * @param in 文件流
     * @return 返回是否成功
     */
    public static boolean upload(String hostname, int port, String username, String password, String basePath,
                                 String filePath, String remoteFileName, InputStream in){

        //第一步：获取客户端连接
        FTPClient client = new FTPClient();

        try{
            client.connect(hostname,port);

            boolean login = client.login(username,password);
            if(login){
                //第二步：获得一个文件

                /*发送之前需要设置一个发送参数
                  指定使用二进制码发送*/
                client.setFileType(FTPClient.BINARY_FILE_TYPE);
                //指定发送的模式为被动模式
                client.enterLocalPassiveMode();
                //指定发送位置
                String path = basePath + filePath;
                boolean direntoryFlag = client.changeWorkingDirectory(path);
                //思路：判断当前配置路径是否存在，如果存在直接删除文件。如果不存在，就一级一级的将文件夹创建好在上传。
                if (direntoryFlag == false){
                    String tempPath = basePath;
                    String[] split = filePath.split("/");
                    for (int i = 0; i < split.length; i++) {
                        if (split[i] != null&&!"".equals(split[i])){
                            tempPath = tempPath + "/" + split[i];
                            //判断当前路径是否存在
                            boolean tempPathFlag = client.changeWorkingDirectory(tempPath);
                            if (!tempPathFlag){
                                //判断如果不存在，创建新的路径
                                client.makeDirectory(tempPath);
                            }
                        }
                    }
                    //重置路径
                    client.changeWorkingDirectory(path);
                }
                //第三步：发送读取到的文件到ftp服务器对应的路径
                client.storeFile(remoteFileName,in);
                return true;
            }
            //第四步：关闭
            client.disconnect();
        }catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }
}
