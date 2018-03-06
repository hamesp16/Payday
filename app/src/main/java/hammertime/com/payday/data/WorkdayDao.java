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
    LiveData<List<Workday>> loadAllWorkdays();

    @Query("SELECT * FROM Workday WHERE workdayId = :workdayId ")
    LiveData<Workday> getWorkdayById(String workdayId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertWorkday(Workday workday);

    @Delete
    void deleteWorkday(Workday workday);
}
