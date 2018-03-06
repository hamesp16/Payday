package hammertime.com.payday.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Workday.class}, version = 1)
public abstract class WorkdayDatabase extends RoomDatabase
{
    public abstract WorkdayDao workdayDao();
}
