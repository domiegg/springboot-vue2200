package freemarker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 复制文件或文件夹
 *
 * zww
 */
public class CopyFileUtil {

    public static void copyDir(String oldPath, String newPath) throws IOException {
        File file = new File(oldPath);
        String[] filePath = file.list();

        if (!(new File(newPath)).exists()) {
            System.out.println("创建目录：" + newPath + ":" + (new File(newPath)).mkdirs());
        }

        for (int i = 0; i < filePath.length; i++) {
            if ((new File(oldPath + file.separator + filePath[i])).isDirectory()) {
                copyDir(oldPath + file.separator + filePath[i], newPath + file.separator + filePath[i]);
            }

            if (new File(oldPath + file.separator + filePath[i]).isFile()) {
                copyFile(oldPath + file.separator + filePath[i], newPath + file.separator + filePath[i]);
            }

        }
    }

    public static void copyFile(String oldPath, String newPath) throws IOException {
        File oldFile = new File(oldPath);
        File file = new File(newPath);
        if (file.exists()) {
            System.out.println("文件：" + file.getName() + " 已存在。");
            return;
        }
        int byteread = 0; // 读取的字节数
        InputStream in = null;
        OutputStream out = null;

        try {
            in = new FileInputStream(oldFile);
            out = new FileOutputStream(file);
            byte[] buffer = new byte[1024];

            while ((byteread = in.read(buffer)) != -1) {
                out.write(buffer, 0, byteread);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null)
                    out.close();
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    // private static String MESSAGE = "";
    //
    // /**
    // * 复制单个文件
    // *
    // * @param srcFileName
    // * 待复制的文件名
    // * @param descFileName
    // * 目标文件名
    // * @param overlay
    // * 如果目标文件存在，是否覆盖
    // * @return 如果复制成功返回true，否则返回false
    // */
    // public static void copyFile(String srcFileName, String destFileName,
    // boolean overlay) {
    // File srcFile = new File(srcFileName);
    //
    // // 判断目标文件是否存在
    // File destFile = new File(destFileName);
    // if (destFile.exists()) {
    // return;
    // } else {
    // // 如果目标文件所在目录不存在，则创建目录
    // if (!destFile.getParentFile().exists()) {
    // // 目标文件所在目录不存在
    // if (!destFile.getParentFile().mkdirs()) {
    // // 复制文件失败：创建目标文件所在目录失败
    // return false;
    // }
    // }
    // }
    //
    // // 复制文件
    // int byteread = 0; // 读取的字节数
    // InputStream in = null;
    // OutputStream out = null;
    //
    // try {
    // in = new FileInputStream(srcFile);
    // out = new FileOutputStream(destFile);
    // byte[] buffer = new byte[1024];
    //
    // while ((byteread = in.read(buffer)) != -1) {
    // out.write(buffer, 0, byteread);
    // }
    // return true;
    // } catch (FileNotFoundException e) {
    // return false;
    // } catch (IOException e) {
    // return false;
    // } finally {
    // try {
    // if (out != null)
    // out.close();
    // if (in != null)
    // in.close();
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // }
    // }
    //
    // /**
    // * 复制整个目录的内容
    // *
    // * @param srcDirName
    // * 待复制目录的目录名
    // * @param destDirName
    // * 目标目录名
    // * @param overlay
    // * 如果目标目录存在，是否覆盖
    // * @return 如果复制成功返回true，否则返回false
    // */
    // public static boolean copyDirectory(String srcDirName, String
    // destDirName, boolean overlay) {
    // // 判断源目录是否存在
    // File srcDir = new File(srcDirName);
    // if (!srcDir.exists()) {
    // MESSAGE = "复制目录失败：源目录" + srcDirName + "不存在！";
    // JOptionPane.showMessageDialog(null, MESSAGE);
    // return false;
    // } else if (!srcDir.isDirectory()) {
    // MESSAGE = "复制目录失败：" + srcDirName + "不是目录！";
    // JOptionPane.showMessageDialog(null, MESSAGE);
    // return false;
    // }
    //
    // // 如果目标目录名不是以文件分隔符结尾，则加上文件分隔符
    // if (!destDirName.endsWith(File.separator)) {
    // destDirName = destDirName + File.separator;
    // }
    // File destDir = new File(destDirName);
    // // 如果目标文件夹存在
    // if (destDir.exists()) {
    // // 如果允许覆盖则删除已存在的目标目录
    // // if (overlay) {
    // // new File(destDirName).delete();
    // // } else {
    // // MESSAGE = "复制目录失败：目的目录" + destDirName + "已存在！";
    // // JOptionPane.showMessageDialog(null, MESSAGE);
    // // return false;
    // // }
    // } else {
    // // 创建目的目录
    // System.out.println("目的目录不存在，准备创建。。。");
    // if (!destDir.mkdirs()) {
    // System.out.println("复制目录失败：创建目的目录失败！");
    // return false;
    // }
    // }
    //
    // boolean flag = true;
    // File[] files = srcDir.listFiles();
    // for (int i = 0; i < files.length; i++) {
    // // 复制文件
    // if (files[i].isFile()) {
    // if (files[i].exists()) {
    // continue;
    // }
    // flag = CopyFileUtil.copyFile(files[i].getAbsolutePath(), destDirName +
    // files[i].getName(), false);
    // if (!flag)
    // break;
    // } else if (files[i].isDirectory()) {
    // flag = CopyFileUtil.copyDirectory(files[i].getAbsolutePath(), destDirName
    // + files[i].getName(), overlay);
    // if (!flag)
    // break;
    // }
    // }
    // if (!flag) {
    // MESSAGE = "复制目录" + srcDirName + "至" + destDirName + "失败！";
    // System.out.println(MESSAGE);// JOptionPane.showMessageDialog(null,
    // // MESSAGE);
    // return false;
    // } else {
    // return true;
    // }
    // }

    public static void main(String[] args) throws IOException {
        CopyFileUtil.copyDir(System.getProperty("user.dir") + "/WebContent/ftls/java", System.getProperty("user.dir") + "/src/com/ognice");
    }
}