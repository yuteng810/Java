package edu.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.service.CalculateService;

public class CalculateAction extends ActionSupport {
    private String num1;
    private String num2;
    private String operation;
    private double result;

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    CalculateService cs = new CalculateService();

    @Override
    public void validate() {
        boolean flag1, flag2;
        flag1 = cs.isNumeric(num1);
        flag2 = cs.isNumeric(num2);
        if (flag1 == false || num1 == null || num1.equals("")) {
            this.addFieldError("num1", "只能输入数字");
        }
        if (flag2 == false || num2 == null || num2.equals("")) {
            this.addFieldError("num2", "只能输入数字");
        }
    }

    @Override
    public String execute() throws Exception {
        double num3;
        double num4;
        try {
            num3 = Double.parseDouble(num1);
            num4 = Double.parseDouble(num2);
        } catch (Exception e) {
            this.addActionError("只能输入数字");
            e.printStackTrace();
            return "fail";
        }
        if (operation.equals("加")) {
            result = num3 + num4;
        }
        if (operation.equals("减")) {
            result = num3 - num4;
        }
        if (operation.equals("乘")) {
            result = num3 * num4;
        }
        if (operation.equals("除")) {
            if (num4 == 0) {
                this.addFieldError("num2", "除数不能为0");
                return "fail";
            } else {
                result = num3 / num4;
            }

        }
        return "success";

    }
}
