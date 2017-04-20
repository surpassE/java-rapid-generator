package com.rapid.framework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.util.FileCopyUtils;

public class CustCopy {

	static Logger logger = Logger.getLogger(CustCopy.class);
	/**
	 * 新生成的文件路径
	 */
	static final String SRC_PATH = "C:\\yrtz\\test\\generator";
	/**
	 * 源文件路径
	 */
	static final String DEST_PATH = "C:\\yrtz\\test\\generator\\dest";
	/**
	 * 文件中自定义内容的关键字
	 */
	static final String JAVA_KEY = "forceretain";
	/**
	 * 用于存储自定义缓存内容
	 */
	static final Map<String, String> map = new HashMap<>();

	static String line = null;
	static String key = null;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		//缓存自定义内容
		cacheContent();
		//复制文件
		copyFiles();
		//将自定义的缓存内容重新写入到文件中
		overrideForceRetain();
	}

	/**
	 * @described			: 缓存需要强制留下的元素
	 * @author				: zc.ding
	 * @project				: java-rapid-generator
	 * @package				: com.rapid.framework.Copy.java
	 * @return				: void
	 * @throws IOException 
	 * @since 				: 2017年4月20日
	 */
	public static void cacheContent() throws IOException{
		File[] files = getFiles(DEST_PATH);
		for(File file : files){
			BufferedReader br = new BufferedReader(new FileReader(file));
			boolean flag = false;
			while((line = br.readLine()) != null){
				key = getKey(line);
				if((line.toLowerCase().indexOf(JAVA_KEY) > -1) || flag){
					sb.append(line).append("\n");
					flag = changeFlag(flag);
				}
			}
			map.put(key, sb.toString());
			br.close();
			clear();
		}
	}
	
	/**
	 * @described			: 改变记录标志位
	 * @author				: zc.ding
	 * @project				: java-rapid-generator
	 * @package				: com.rapid.framework.CustCopy.java
	 * @return				: boolean
	 * @since 				: 2017年4月20日
	 * @param flag
	 * @return
	 */
	static boolean changeFlag(boolean flag){
		if(line.toLowerCase().indexOf(JAVA_KEY) > -1){
			return !flag;
		}
		return flag;
	}
	
	/**
	 * @described			: 完成文件的移动
	 * @author				: zc.ding
	 * @project				: java-rapid-generator
	 * @package				: com.rapid.framework.Copy.java
	 * @return				: void
	 * @since 				: 2017年4月20日
	 */
	public static void copyFiles() throws IOException {
		File[] files = getFiles(SRC_PATH);
		for(File file : files){
			File newFile = new File(DEST_PATH + File.separator + file.getName());
			int count = FileCopyUtils.copy(file, newFile);
			if(count > 0){
				logger.debug("ok" + file.getAbsolutePath() + " ==> " + newFile.getAbsolutePath());
			}else{
				throw new IOException("fail" + file.getAbsolutePath() + " ==> " + newFile.getAbsolutePath());
			}
		}
	}

	/**
	 * @described			: 将自定义的数据重新写回到文件中
	 * @author				: zc.ding
	 * @project				: java-rapid-generator
	 * @package				: com.rapid.framework.Copy.java
	 * @return				: void
	 * @since 				: 2017年4月20日
	 */
	public static void overrideForceRetain() throws IOException{
		File[] files = getFiles(DEST_PATH);
		for(File file : files){
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((line = br.readLine()) != null){
				key = getKey(line);
				if("}".equals(line.trim()) && line.startsWith("}") || "</mapper>".equals(line.trim())){
					sb.append(map.get(key));
				}
				sb.append(line).append("\n");
			}
			br.close();
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(sb.toString());
			bw.flush();
			bw.close();
			clear();
		}
	}

	static File[] getFiles(String file){
		List<File> list = new ArrayList<>();
		File[] files = new File(file).listFiles();
		if(files != null){
			for(File f : files){
				if(f.isFile()){
					list.add(f);
				}
			}
		}
		return list.toArray(new File[]{});
	}

	/**
	 * @described			: 获得文件中唯一标识
	 * @author				: zc.ding
	 * @project				: java-rapid-generator
	 * @package				: com.rapid.framework.CustCopy.java
	 * @return				: String
	 * @since 				: 2017年4月20日
	 * @param line
	 * @return
	 */
	private static String getKey(String line){
		if(line.startsWith("public class") || line.indexOf("<mapper namespace=") > -1){
			return line;
		}
		return null;
	}

	private static void clear(){
		line = null;
		key = null;
		sb = new StringBuilder();
	}
	
	public void demo(){
//		
	}
}
