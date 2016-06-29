package com.project.db.tables;

import com.google.gson.reflect.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Date;
import java.sql.Time;
import io.hasura.db.*;
import com.project.db.tables.records.*;
public class Users extends Table<UsersRecord> {
    public static final Users USERS = new Users();

    public Users() {
        super("users");
    }

    public Type getInsResType() {
        return new TypeToken<InsertResult<UsersRecord>>() {}.getType();
    }

    public Type getSelResType() {
        return new TypeToken<ArrayList<UsersRecord>>() {}.getType();
    }

    public Type getUpdResType() {
        return new TypeToken<UpdateResult<UsersRecord>>() {}.getType();
    }

    public Type getDelResType() {
        return new TypeToken<DeleteResult<UsersRecord>>() {}.getType();
    }

    public final PGField<UsersRecord, Integer> USER_ID = new PGField<>("user_id");
    public final PGField<UsersRecord, String> USERNAME = new PGField<>("username");

}
