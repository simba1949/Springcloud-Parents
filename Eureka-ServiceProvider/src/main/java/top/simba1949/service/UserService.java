package top.simba1949.service;

import top.simba1949.common.UserCommon;

import java.util.List;

/**
 * @author simba1949@outlook.com
 * @date 2018/9/16 15:24
 */
public interface UserService {

    List<UserCommon> findAll();

    void insert(UserCommon userCommon);

    void delete(Integer id);

    void update(UserCommon userCommon) throws Exception;
}
