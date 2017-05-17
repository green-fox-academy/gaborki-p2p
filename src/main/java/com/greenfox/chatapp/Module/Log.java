package com.greenfox.chatapp.Module;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.SchemaOutputResolver;

@Entity
public class Log {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String path;
  private String method;
  private String timestamp;
  private String logLevel;
  private String requestData;

  public Log(){
    this.method = "method";
    this.path = "path";
    this.timestamp = getTime();
    this.logLevel = "INFO";
    this.requestData = "nothing";
    printLog();
  }

  public Log(String endpoint, String method){
    this.method = method;
    this.path = endpoint;
    this.timestamp = getTime();
    this.logLevel = "INFO";
    this.requestData = "nothing";
    printLog();
  }

  public void printLog(){
    System.out.println(this.timestamp);
  }

  public String getTime(){
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
    return now.format(formatter);
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public String getLogLevel() {
    return logLevel;
  }

  public void setLogLevel(String logLevel) {
    this.logLevel = logLevel;
  }

  public String getRequestData() {
    return requestData;
  }

  public void setRequestData(String requestData) {
    this.requestData = requestData;
  }
}
