package com.example.coursemanagementapp.model;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CourseDatabase_Impl extends CourseDatabase {
  private volatile CategoryDao _categoryDao;

  private volatile CourseDao _courseDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `categories_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `category_name` TEXT, `category_description` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `courses_table` (`course_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `course_name` TEXT, `unit_price` TEXT, `category_id` INTEGER NOT NULL, FOREIGN KEY(`category_id`) REFERENCES `categories_table`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '44fb958d9454817eb35d4041da03edf6')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `categories_table`");
        _db.execSQL("DROP TABLE IF EXISTS `courses_table`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsCategoriesTable = new HashMap<String, TableInfo.Column>(3);
        _columnsCategoriesTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategoriesTable.put("category_name", new TableInfo.Column("category_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategoriesTable.put("category_description", new TableInfo.Column("category_description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCategoriesTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCategoriesTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCategoriesTable = new TableInfo("categories_table", _columnsCategoriesTable, _foreignKeysCategoriesTable, _indicesCategoriesTable);
        final TableInfo _existingCategoriesTable = TableInfo.read(_db, "categories_table");
        if (! _infoCategoriesTable.equals(_existingCategoriesTable)) {
          return new RoomOpenHelper.ValidationResult(false, "categories_table(com.example.coursemanagementapp.model.Category).\n"
                  + " Expected:\n" + _infoCategoriesTable + "\n"
                  + " Found:\n" + _existingCategoriesTable);
        }
        final HashMap<String, TableInfo.Column> _columnsCoursesTable = new HashMap<String, TableInfo.Column>(4);
        _columnsCoursesTable.put("course_id", new TableInfo.Column("course_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCoursesTable.put("course_name", new TableInfo.Column("course_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCoursesTable.put("unit_price", new TableInfo.Column("unit_price", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCoursesTable.put("category_id", new TableInfo.Column("category_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCoursesTable = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysCoursesTable.add(new TableInfo.ForeignKey("categories_table", "CASCADE", "NO ACTION",Arrays.asList("category_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesCoursesTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCoursesTable = new TableInfo("courses_table", _columnsCoursesTable, _foreignKeysCoursesTable, _indicesCoursesTable);
        final TableInfo _existingCoursesTable = TableInfo.read(_db, "courses_table");
        if (! _infoCoursesTable.equals(_existingCoursesTable)) {
          return new RoomOpenHelper.ValidationResult(false, "courses_table(com.example.coursemanagementapp.model.Course).\n"
                  + " Expected:\n" + _infoCoursesTable + "\n"
                  + " Found:\n" + _existingCoursesTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "44fb958d9454817eb35d4041da03edf6", "55f50e6204c73f7dc16f516fcaa8384b");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "categories_table","courses_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `categories_table`");
      _db.execSQL("DELETE FROM `courses_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(CategoryDao.class, CategoryDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CourseDao.class, CourseDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public CategoryDao categoryDao() {
    if (_categoryDao != null) {
      return _categoryDao;
    } else {
      synchronized(this) {
        if(_categoryDao == null) {
          _categoryDao = new CategoryDao_Impl(this);
        }
        return _categoryDao;
      }
    }
  }

  @Override
  public CourseDao courseDao() {
    if (_courseDao != null) {
      return _courseDao;
    } else {
      synchronized(this) {
        if(_courseDao == null) {
          _courseDao = new CourseDao_Impl(this);
        }
        return _courseDao;
      }
    }
  }
}
