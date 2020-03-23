package com.zhibinwang;

import com.zhibinwang.cache.Person;
import com.zhibinwang.cache.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.List;

/**
 * @author zhibin.wang
 * @desc
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJPA {

    @Autowired
    PersonRepository personRepository;

    @Test
    public void test() {
        List<Person> all = personRepository.findAll();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("c://1.txt");
            ObjectOutputStream oStream = new ObjectOutputStream(fileOutputStream);
            oStream.writeObject(all);
            oStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test2() throws IOException, ClassNotFoundException {
        FileInputStream fileStream = null;
        try {
            fileStream = new FileInputStream("c://1,txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //创建对象输入流
        ObjectInputStream iStream = new ObjectInputStream(fileStream);
        //读取对象
        Object oneObject = iStream.readObject();
        //转换对象
        List<Person> all = (List<Person>) oneObject;
        personRepository.saveAll(all);
        //关闭对象输入流
        iStream.close();
        //关闭文件输入流
        fileStream.close();


    }

    public boolean genarateEncryptFile(String tempFile, String fileName,
                                       String sfileSize, String fileKey) throws Exception {
        boolean flag = true;
        FileInputStream is = null;
        FileOutputStream io = null;
        try {
            // 创建文件输入流对象
            is = new FileInputStream(tempFile);
            io = new FileOutputStream(fileName);
            if ("".equals(sfileSize) || "0".equals(sfileSize)) {
                LOG.error("platform config error:fileSize should >0!");
                return false;
            }
            int fileSize = Integer.parseInt(sfileSize);// 设定读取的字节数
            byte buffer[] = new byte[fileSize];// 读取输入流
            int len = 0;
            while (((len = is.read(buffer)) != -1) && (fileSize > 0)) {
                // 调用加密机加密文件（要求不超过4M:江南天安设定）
                byte[] temp = new byte[len];
                System.arraycopy(buffer, 0, temp, 0, len);
//    byte[] out = hsmService.encrypt_TripleDesECB(fileKey, temp);

                int outLen = 8 * ((temp.length - 1) / 8 + 1);
                byte[] out = new byte[outLen];
                out = tass.encrypt(fileKey, "01", temp, temp.length, out, "00000000");

                if (out == null) {
                    flag = false;
                    LOG.error("tass out is null");
                    throw new Exception("encry data file error");
                }
                io.write(out);
            }
        } catch (IOException ioe) {
            LOG.error("genarateEncryptFile io error:" + ioe);
            flag = false;
            throw new IOException("encry data file IOException");
        } catch (Exception e) {
            LOG.error("genarateEncryptFile io error:" + e);
            flag = false;
            throw new Exception("encry data file Exception");
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    LOG.error("close in stream error:" + e);
                    return false;
                }
            }
            if (io != null) {
                try {
                    io.close();
                } catch (IOException e) {
                    LOG.error("close out stream error:" + e);
                    return false;
                }
            }
        }
        return flag;
    }
