package com.alfimenkov.lab9;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;

public class XmlParser {

    private final ArrayList<Project> projects;

    public XmlParser() {
        projects = new ArrayList<Project>();
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public boolean parse(XmlPullParser xpp){
        boolean status = true;
        Project currentProject = null;
        boolean inEntry = false;
        String textValue = "";

        try{
            int eventType = xpp.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT){

                String tagName = xpp.getName();
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        if("project".equalsIgnoreCase(tagName)){
                            inEntry = true;
                            currentProject = new Project();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if(inEntry){
                            if("project".equalsIgnoreCase(tagName)){
                                projects.add(currentProject);
                                inEntry = false;
                            } else if("name".equalsIgnoreCase(tagName)){
                                currentProject.setName(textValue);
                            } else if("description".equalsIgnoreCase(tagName)){
                                currentProject.setDescription(textValue);
                            }
                        }
                        break;
                    default:
                }
                eventType = xpp.next();
            }
        }
        catch (Exception e){
            status = false;
            e.printStackTrace();
        }
        return  status;
    }
}
