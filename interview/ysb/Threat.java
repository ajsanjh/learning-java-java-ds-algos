package ysb;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Threat {

	List<LogEntity> parseFile() throws IOException {
		Stream<String> lines = Files.lines(Paths.get("C:\\OFFSHORE\\learning\\java\\workspace\\java-ds-algos\\interview\\ysb\\log.txt"));
		
		List<LogEntity> logs = lines.map(i -> new LogEntity(
				LocalTime.parse(i.split("|")[0]), 
				i.split("|")[2], 
				i.split("|")[3])).collect(Collectors.toList());
		
		
		logs.stream().forEach(System.out::println);
		
		return null;
	}
	
	public static void main(String[] args) throws IOException {

		new Threat().parseFile();
		
		
	}





	private class LogEntity {
		private LocalTime time;
		private String url;
		private String ip;
		public LogEntity(LocalTime time, String url, String ip) {
			super();
			this.time = time;
			this.url = url;
			this.ip = ip;
		}
		public LocalTime getTime() {
			return time;
		}
		public void setTime(LocalTime time) {
			this.time = time;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getIp() {
			return ip;
		}
		public void setIp(String ip) {
			this.ip = ip;
		}
		@Override
		public String toString() {
			return "LogEntity [time=" + time + ", url=" + url + ", ip=" + ip + "]";
		}
	}
}