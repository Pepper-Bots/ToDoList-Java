package todo_list;

import java.util.Date;


public class DatedTask extends Task {


    private Date dueDate;

    public Date getdueDate() { return dueDate; }

    }

    public void setdueDate(Date dueDate) {
    }



    // redéfinition de la méthode toString() pour inclure la date d'échéance
    @Override
    public String toString() {
        return "DatedTask + " +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", done=" + done +
                ", user=" + creator +
                ", dueDate=" + dueDate +
                '}';
    }



    }

