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

package com.helicalinsight.admin.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * This is persistent class for role which maps it's properties with role table
 * and persist them to a database, this class's object or instance in stored in
 * role table as per rule this class should have the default constructor, as
 * well as getter and setter method's for it's properties Annotation Entity mark
 * this class as Entity Bean and annotation Table allows you to specify the
 * details of the table that will be used to persist the entity in the database.
 *
 * @author Muqtar Ahmed
 */
@Entity
@Table(name = "role")
public class Role implements Serializable {

    /**
     * this is static and final filed of serial version id automatically
     * generated by eclipse
     */

    private static final long serialVersionUID = 1L;

    /**
     * each entity bean have the primary key and annotate with Id generatedvalue
     * generate the automaticaly determined the most appropriate primary key
     * with strategy
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * details of the column role name to which field's or properties is mapped and this property
     * should not be empty
     */

    @NotNull
    @Size(min = 1)
    private String role_name;


    /**
     * ManyToMany mapping between role and user_role table.
     */

    //@ManyToMany(mappedBy = "roles")
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    //@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "role_id"),
    // inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "role_id",
            referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "user_id",
            referencedColumnName = "id")})
    private List<User> users;

    /**
     * default constructor
     */

    public Role() {
    }

    /**
     * over loaded constructor with two arguments role name
     *
     * @param roleName role name
     */

    public Role(String roleName) {
        this.role_name = roleName;
    }

    /**
     * getter method for id primary key for role table
     *
     * @return generated id
     */

    public int getId() {
        return id;
    }

    /**
     * setter method for id primary key for role table
     *
     * @param id generated id
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter method for role name
     *
     * @return role name
     */

    public String getRole_name() {
        return role_name;
    }

    /**
     * setter method for role name
     *
     * @param role_name role name
     */

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    /**
     * getter method for list of user objects
     *
     * @return list of user objects
     */

    public List<User> getUsers() {
        return users;
    }

    /**
     * setter method for list of user objects
     *
     * @param users user object
     */

    public void setUsers(List<User> users) {
        this.users = users;
    }


}

