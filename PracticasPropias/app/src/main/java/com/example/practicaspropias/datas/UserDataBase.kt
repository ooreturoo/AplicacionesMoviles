package com.example.practicaspropias.datas

import com.example.practicaspropias.datas.User

class UserDataBase {

    companion object {
        var userList: MutableList<User> = mutableListOf()


        fun checkUserExistence(userName: String): Boolean {

            var exist = false

            for (user in userList) {

                if (user.name == userName) {

                    exist = true

                }

            }

            return exist

        }

        fun checkMailExistence(email: String): Boolean {

            var exist = false

            for (user in userList) {

                if (user.email == email) {

                    exist = true

                }

            }

            return exist

        }

        fun checkLoginUser(userName : String, password : String): Int {

            var userFound = -1

            for (user in userList) {

                if (user.name == userName) {

                    userFound = 0

                    if (user.password == password) {

                        userFound = 1

                    }

                    break

                }

            }

            return userFound

        }
    }

}