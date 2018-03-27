/**
 * @(#)ProjectMember.java
 *
 *
 * @author
 * @version 1.00 2018/3/27
 */


public class ProjectMember {
	public String name;
	public String project;

    public ProjectMember(String name, String project) {
    	this.name = name;
    	this.project = project;
    }

    public void setName(String name){
    	this.name = name;
    }

    public String getName(){
    	return name;
    }

    public void setProject(String project){
     	this.project = project;
    }

    public String getProject(){
    	return project;
    }

    public String toString(){
    	return "Name: " + name + " Project: " + project;
    }



}