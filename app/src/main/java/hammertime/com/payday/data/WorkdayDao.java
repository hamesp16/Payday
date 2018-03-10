package hammertime.com.payday.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WorkdayDao
{
    @Query("SELECT * FROM Workday")
    LiveData<List<Workday>> getAllWorkdays();

    @Query("SELECT * FROM Workday WHERE workdayId = :workdayId ")
    LiveData<Workday> getWorkdayById(String workdayId);

    @Query("DELETE FROM Workday")
    void deleteAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertWorkday(Workday workday);

    @Delete
    void deleteWorkday(Workday workday);

    //TODO: make a query for ordering by last added date
}
