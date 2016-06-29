package com.project.db.tables.records;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Date;
import java.sql.Time;

public class UsersRecord {
    @SerializedName("user_id")
    public Integer userId;

    @SerializedName("username")
    public String username;

}
