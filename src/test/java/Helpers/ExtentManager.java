package Helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentManager {
    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {
        String ambiente= "Homologação";
        String pathFile =  System.getProperty("user.dir")+ File.separator +"TestReport"+ File.separator +"relatorioTestes.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(pathFile);
        String css ="#img {\n" +
                "    width: 120px;\n" +
                "    height: 35px;\n" +
                "    float: left;\n" +
                "    position: absolute;\n" +
                "    margin-left: -40%;\n" +
                "    margin-top: -3%;\n" +
                "}";

        String js = " $(document).ready(function() {\n" +


                "$('link[rel=\"shortcut icon\"]').attr('href','https://www.texoit.com/icon.f0405c76.png');\n" +
                "$('.logo').removeAttr('style');\n"+
                "$('.logo').html('<img src=\"https://www.texoit.com/icon.f0405c76.png\" style=\"margin-top:10px\">');\n"+
                "$('.nav-logo > a').attr('href','https://www.texoit.com');\n"+
                "$('.nav-logo > a').attr('target','_blank');\n"+
                "});";

        reporter.config().setDocumentTitle("Teste Automatizados de API ");
        reporter.config().setEncoding("utf-8");
        reporter.config().setReportName(
                "<img id='img' src='https://d33wubrfki0l68.cloudfront.net/c0058fb67e00f9fccf6289f1a59289e0ac5cb667/a3bdc/logo_texosite.df1d3477.svg' />\n" +
                        "\t<span>Relat&oacute;rio de execu&ccedil;&atilde;o dos testes</span>\n" );
        reporter.config().setJs(js);
        reporter.config().setCss(css);
        reporter.config().setTheme(Theme.DARK);
        String OS = System.getProperty("os.name");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Ambiente de teste", ambiente);
        extentReports.setSystemInfo("Autor", "Tito Neto");

        extentReports.setSystemInfo("Sistema Operacional", OS);
        return extentReports;
    }
}