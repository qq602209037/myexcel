package com.yw.myexcel.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.util.List;


@ExcelTarget("employee")
public class Employee {
    @Excel(name="办事处")
    String bsc;
    @Excel(name="姓名")
    String xm;
    @Excel(name = "工作态度（5）")
    String gztd;
    @Excel(name = "安全与卫生（5）")
    String aqyws;
    @Excel(name="劳动纪律（5）")
    String ldjl;
    @Excel(name = "订货（10）")
    String dh;
    @Excel(name = "发货（10）")
    String fh;
    @Excel(name="结算（10）")
    String js;
    @Excel(name = "费用（10）")
    String fy;
    @Excel(name = "销售流向（30）")
    String xslx;
    @Excel(name = "商务发货任务（元）")
    String swfhrw;

    @Excel(name="商务发货完成（元）")
    String swfhwc;
    @Excel(name = "发货得分")
    String fhdf;
    @Excel(name = "本月超额")
    String byce;
    @Excel(name = "上月超额转本月")
    String sycezby;
    @Excel(name = "超额分")
    String cef;
    @Excel(name = "分数合计（10）")
    String fshj;
    @Excel(name = "结转下月超额（元）")
    String jzxyce;
    @Excel(name = "商务回款任务（元）")
    String swhkrw;
    @Excel(name = "商务回款完成（元）")
    String swhkwc;
    @Excel(name = "回款得分")
    String hkdf;
    @Excel(name = "本月超额")
    String byce2;
    @Excel(name = "上月超额转本月")
    String sycezby2;
    @Excel(name = "超额分")
    String cef2;
    @Excel(name = "分数合计（5）")
    String fshj2;
    @Excel(name = "结转下月超额（元）")
    String jzxyce2;
    @Excel(name = "销售任务（15）")
    String xsrw;
    @Excel(name = "分数合计")
    String fshj3;
    @Excel(name = "月考核奖（元）")
    String ykhj;
    @Excel(name = "备注")
    String bz;

    public String getLdjl() {
        return ldjl;
    }

    public void setLdjl(String ldjl) {
        this.ldjl = ldjl;
    }

    public String getDh() {
        return dh;
    }

    public void setDh(String dh) {
        this.dh = dh;
    }

    public String getFh() {
        return fh;
    }

    public void setFh(String fh) {
        this.fh = fh;
    }

    public String getJs() {
        return js;
    }

    public void setJs(String js) {
        this.js = js;
    }

    public String getFy() {
        return fy;
    }

    public void setFy(String fy) {
        this.fy = fy;
    }

    public String getXslx() {
        return xslx;
    }

    public void setXslx(String xslx) {
        this.xslx = xslx;
    }

    public String getSwfhrw() {
        return swfhrw;
    }

    public void setSwfhrw(String swfhrw) {
        this.swfhrw = swfhrw;
    }

    public String getSwfhwc() {
        return swfhwc;
    }

    public void setSwfhwc(String swfhwc) {
        this.swfhwc = swfhwc;
    }

    public String getFhdf() {
        return fhdf;
    }

    public void setFhdf(String fhdf) {
        this.fhdf = fhdf;
    }

    public String getByce() {
        return byce;
    }

    public void setByce(String byce) {
        this.byce = byce;
    }

    public String getSycezby() {
        return sycezby;
    }

    public void setSycezby(String sycezby) {
        this.sycezby = sycezby;
    }

    public String getCef() {
        return cef;
    }

    public void setCef(String cef) {
        this.cef = cef;
    }

    public String getJzxyce() {
        return jzxyce;
    }

    public void setJzxyce(String jzxyce) {
        this.jzxyce = jzxyce;
    }

    public String getSwhkrw() {
        return swhkrw;
    }

    public void setSwhkrw(String swhkrw) {
        this.swhkrw = swhkrw;
    }

    public String getSwhkwc() {
        return swhkwc;
    }

    public void setSwhkwc(String swhkwc) {
        this.swhkwc = swhkwc;
    }

    public String getHkdf() {
        return hkdf;
    }

    public void setHkdf(String hkdf) {
        this.hkdf = hkdf;
    }

    public String getByce2() {
        return byce2;
    }

    public void setByce2(String byce2) {
        this.byce2 = byce2;
    }

    public String getSycezby2() {
        return sycezby2;
    }

    public void setSycezby2(String sycezby2) {
        this.sycezby2 = sycezby2;
    }

    public String getCef2() {
        return cef2;
    }

    public void setCef2(String cef2) {
        this.cef2 = cef2;
    }

    public String getFshj2() {
        return fshj2;
    }

    public void setFshj2(String fshj2) {
        this.fshj2 = fshj2;
    }

    public String getJzxyce2() {
        return jzxyce2;
    }

    public void setJzxyce2(String jzxyce2) {
        this.jzxyce2 = jzxyce2;
    }

    public String getFshj3() {
        return fshj3;
    }

    public void setFshj3(String fshj3) {
        this.fshj3 = fshj3;
    }

    public String getXsrw() {
        return xsrw;
    }

    public void setXsrw(String xsrw) {
        this.xsrw = xsrw;
    }

    public String getFshj() {
        return fshj;
    }

    public void setFshj(String fshj) {
        this.fshj = fshj;
    }

    public String getYkhj() {
        return ykhj;
    }

    public void setYkhj(String ykhj) {
        this.ykhj = ykhj;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getBsc() {
        return bsc;
    }

    public void setBsc(String bsc) {
        this.bsc = bsc;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getGztd() {
        return gztd;
    }

    public void setGztd(String gztd) {
        this.gztd = gztd;
    }

    public String getAqyws() {
        return aqyws;
    }

    public void setAqyws(String aqyws) {
        this.aqyws = aqyws;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "bsc='" + bsc + '\'' +
                ", xm='" + xm + '\'' +
                ", gztd='" + gztd + '\'' +
                ", aqyws='" + aqyws + '\'' +
                ", ldjl='" + ldjl + '\'' +
                ", dh='" + dh + '\'' +
                ", fh='" + fh + '\'' +
                ", js='" + js + '\'' +
                ", fy='" + fy + '\'' +
                ", xslx='" + xslx + '\'' +
                ", swfhrw='" + swfhrw + '\'' +
                ", swfhwc='" + swfhwc + '\'' +
                ", fhdf='" + fhdf + '\'' +
                ", byce='" + byce + '\'' +
                ", sycezby='" + sycezby + '\'' +
                ", cef='" + cef + '\'' +
                ", fshj='" + fshj + '\'' +
                ", jzxyce='" + jzxyce + '\'' +
                ", swhkrw='" + swhkrw + '\'' +
                ", swhkwc='" + swhkwc + '\'' +
                ", hkdf='" + hkdf + '\'' +
                ", byce2='" + byce2 + '\'' +
                ", sycezby2='" + sycezby2 + '\'' +
                ", cef2='" + cef2 + '\'' +
                ", fshj2='" + fshj2 + '\'' +
                ", jzxyce2='" + jzxyce2 + '\'' +
                ", xsrw='" + xsrw + '\'' +
                ", fshj3='" + fshj3 + '\'' +
                ", ykhj='" + ykhj + '\'' +
                ", bz='" + bz + '\'' +
                '}';
    }
}
