package com.model;

import com.beans.Scheduler;
import com.controller.MainController;
import com.databases.MysqlHandler;
import com.utils.HtmlCode;
import com.utils.objForService;
import sun.security.util.AuthResources_it;

import javax.swing.text.html.HTMLDocument;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class ServicesModel {

    private String _res = "";
    private  String _login;
    private  Integer _id;
    private List<String> listFrom = new ArrayList<String>();
    private List<String> listTo = new ArrayList<String>();

    public ServicesModel(String login)throws SQLException{
        _login =login;
     //   findId();

    }

    public void addServices(String from, String to) throws SQLException{
        ResultSet rs = MysqlHandler.getDbCon().query("SELECT MAX(ID) FROM `CONNECTION`");
        Integer ID = 0;
        while (rs.next()) {
            ID = rs.getInt("MAX(ID)");
        }
        ID = ID + 1;
        MysqlHandler.getDbCon().insert("INSERT INTO `CONNECTION` (`ID`, `ID_USER`, `FROM_API`, `TO_API`) VALUES ('" + ID.toString() + "' ,'" + _id.toString() + "', '" + from + "', '" + to+"')");
    }

    public void getServices() throws SQLException{
       // FillFromList();
        //FillToList();
        makeRes();
    }

    public String getRes() {
        return _res;
    }

    private void makeRes() {
        Iterator i = Scheduler.getMap().keySet().iterator();
        while (i.hasNext())
        {
            String clef =(String)i.next();
            System.out.println("LA CLEF EST " + clef);
            String from = clef.split(":")[0];
            String to = clef.split(":")[1];
            if (from.equals("Sensit") && to.equals("Slack"))
                _res += HtmlCode.getHCode(clef,"images/thermometer.png", "images/slack-images.png","Temperature of your house on your slack");
            if (from.equals("Sensit") && to.equals("Twitter"))
                _res += HtmlCode.getHCode(clef,"images/thermometer.png", "images/twitter.png","Temperature of your house on Twitter");
            if (from.equals("Sensit") && to.equals("Facebook"))
                _res += HtmlCode.getHCode(clef,"images/thermometer.png", "images/fb.png","Temperature of your house on facebook");
            if (from.equals("Redtube") && to.equals("Slack"))
                _res += HtmlCode.getHCode(clef,"images/icon_xl.png", "images/slack-images.png","Lastest Redtube Video on your Slack");
            if (from.equals("Redtube") && to.equals("Facebook"))
                _res += HtmlCode.getHCode(clef,"images/icon_xl.png", "images/fb.png","Lastest Redtube Video on your facebook");
            if (from.equals("Redtube") && to.equals("Twitter"))
                _res += HtmlCode.getHCode(clef,"images/icon_xl.png", "images/twitter.png","Lastest Redtube Video on your Twitter");
            if (from.equals("Geolocalisation") && to.equals("Slack"))
                _res += HtmlCode.getHCode(clef,"images/map.png", "images/slack-images.png","Your location on your slack");
            if (from.equals("Geolocalisation") && to.equals("Twitter"))
                _res += HtmlCode.getHCode(clef,"images/map.png", "images/twitter.png","Your location on your Twitter");
            if (from.equals("Geolocalisation") && to.equals("Facebook"))
                _res += HtmlCode.getHCode(clef,"images/map.png", "images/fb.png","Your location on your facebook");
            if (from.equals("Youtube") && to.equals("Slack"))
                _res += HtmlCode.getHCode(clef,"images/youtube.png", "images/slack-images.png","Lastest video id comment on your slack");
            if (from.equals("Youtube") && to.equals("Twitter"))
                _res += HtmlCode.getHCode(clef,"images/youtube.png", "images/twitter.png","Lastest video id comment on your Twitter");
            if (from.equals("Youtube") && to.equals("Facebook"))
                _res += HtmlCode.getHCode(clef,"images/youtube.png", "images/fb.png","Lastest video id comment on your facebook");
            if (from.equals("Netfix") && to.equals("Slack"))
                _res += HtmlCode.getHCode(clef,"images/Apps-Netfix-icon.png", "images/slack-images.png","Lastest netfix id comment on your slack");
            if (from.equals("Netfix") && to.equals("Twitter"))
                _res += HtmlCode.getHCode(clef,"images/Apps-Netfix-icon.png", "images/twitter.png","Lastest netfix comment on your Twitter");
            if (from.equals("Netfix") && to.equals("Facebook"))
                _res += HtmlCode.getHCode(clef,"images/Apps-Netfix-icon.png", "images/fb.png","Lastest netfix comment on your facebook");


        }
//        for (int i =0; i < listTo.size(); i++){
//            if (listFrom.get(i).equals("Sensit") && listTo.get(i).equals("Slack"))
//                _res += HtmlCode.SenSlack();
//            if (listFrom.get(i).equals("Sensit") && listTo.get(i).equals("Yammer"))
//                _res += HtmlCode.SenYammer();
//            if (listFrom.get(i).equals("Sensit") && listTo.get(i).equals("Twitter"))
//                _res += HtmlCode.SenTwitter();
//            if (listFrom.get(i).equals("Redtube") && listTo.get(i).equals("Slack"))
//                _res += HtmlCode.RedSlack();
//            if (listFrom.get(i).equals("Redtube") && listTo.get(i).equals("Yammer"))
//                _res += HtmlCode.RedYammer();
//            if (listFrom.get(i).equals("Redtube") && listTo.get(i).equals("Twitter"))
//                _res += HtmlCode.RedTwitter();
//        }
    }

    private void findId() throws SQLException {
        ResultSet rs = MysqlHandler.getDbCon().query("SELECT ID FROM `USERS` WHERE UserName ='" + _login +"'");
        _id = 0;
        while (rs.next()) {
            _id = rs.getInt("ID");
        }
    }

    private void FillFromList()throws SQLException {
        Iterator i = MainController.getUserController(_login).getGetMap().keySet().iterator();

        while (i.hasNext())
        {
            listFrom.add((String)i.next());
        }
    /*    ResultSet rs = MysqlHandler.getDbCon().query("SELECT CONNECTION.FROM_API FROM `CONNECTION` WHERE ID_USER ='" + _id.toString() +"'");
        while (rs.next()) {
            listFrom.add(rs.getString("CONNECTION.FROM_API"));
        }*/
    }

    private void FillToList()throws SQLException {
        Iterator i = MainController.getUserController(_login).getPostMap().keySet().iterator();

        while (i.hasNext())
        {
            listTo.add((String)i.next());
        }
//        ResultSet rs = MysqlHandler.getDbCon().query("SELECT CONNECTION.TO_API FROM `CONNECTION` WHERE ID_USER ='" + _id.toString() +"'");
//        while (rs.next()) {
//            listTo.add(rs.getString("CONNECTION.TO_API"));
//        }
    }
}
