/**
 *    Copyright (C) 2013-2019 Helical IT Solutions (http://www.helicalinsight.com) - All rights reserved.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.helicalinsight.datasource.csv;

import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.Statement;

public class CreateDatabaseToDumpCSV {

    public static void createTable(String fields, String tableName, Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();

            statement.execute("CREATE TABLE " + tableName + "(" + fields + ")");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            DbUtils.closeQuietly(statement);
        }
    }
}
