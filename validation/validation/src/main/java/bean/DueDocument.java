package bean;

import bean.validation.Dates;

import java.util.Date;

public class DueDocument extends Document {

    @Dates
    private Date dueDate;

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
