package top.simba1949.service.impl;

import org.springframework.stereotype.Service;
import top.simba1949.common.UserCommon;
import top.simba1949.service.UserService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author simba1949@outlook.com
 * @date 2018/9/16 15:25
 */
@Service
public class UserServiceImpl implements UserService {

    private Map<Integer, UserCommon> map = new HashMap<>(16);
    private List<UserCommon> list = new ArrayList<>();
    private Integer size = 16;

    @PostConstruct
    public void init(){
        for (int i = 0; i < 16; i++){
            UserCommon common = new UserCommon();
            common.setId(i);
            common.setUsername("李白" + i);
            common.setPassword("password" + i);
            map.put(i,common);
        }
        map2List();
    }

    public void map2List(){
        list.clear();
        for (Integer integer : map.keySet()) {
            UserCommon common = map.get(integer);
            list.add(common);
        }
    }

    @Override
    public List<UserCommon> findAll() {
        return list;
    }

    @Override
    public void insert(UserCommon userCommon) {
        size += 1;
        userCommon.setId(size);
        map.put(size,userCommon);
        map2List();
    }

    @Override
    public void delete(Integer id) {
        map.remove(id);
        map2List();
    }

    @Override
    public void update(UserCommon userCommon) throws Exception {
        if (null == userCommon.getId()){
            throw new Exception();
        }
        map.put(userCommon.getId(),userCommon);
        map2List();
    }
}
