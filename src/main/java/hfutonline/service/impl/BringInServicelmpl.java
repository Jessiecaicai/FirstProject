package hfutonline.service.impl;

import hfutonline.dao.BringInDao;
import hfutonline.dto.Result;
import hfutonline.entity.BringIn;
import hfutonline.exception.BringInException;
import hfutonline.service.BringInService;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BringInServicelmpl implements BringInService{

        @Resource
        private BringInDao bringInDao;

        @Override
        public List<BringIn> listBringInById(Integer id) throws BringInException{
            if (id == null) {
                throw new BringInException("查找的参数有误");
            }
            try{
                 List<BringIn> listBringInById=bringInDao.listBringInById(id);
                return listBringInById;
            }catch(Exception e){
                e.printStackTrace();
                throw new BringInException("false",e);
            }
        }

        @Override
        public Integer total() throws BringInException{
            Integer total;
            try{
                total=bringInDao.total();
                return total;
            }catch(Exception e){
                e.printStackTrace();
                throw new BringInException("计算出错",e);
            }
        }

        @Override
        public List<BringIn> listAll() throws BringInException {
            try {
                List<BringIn> list = bringInDao.listAll();
                return list;
            } catch (Exception e) {
                e.printStackTrace();
                throw new BringInException("查询招聘人员失败", e);
            }
        }

        @Override
        public List<BringIn> page(Integer start,Integer count) throws  BringInException{
            Integer total=bringInDao.total();
            Integer next=start+count;
            Integer pre=start-count;
            Integer last;
            try{
                if (0 == total % count)
                    last = total - count;
                else
                    last = total - total % count;

                List<BringIn> page=bringInDao.page(start, count);
                return page;
            }catch(Exception e){
                e.printStackTrace();
                throw new BringInException("分页失败");
            }
        }

        /**
     * way:add
     *
     * @author Jessie
     * @param bringIn
     * @throws BringInException
     * @since JDK 1.8
     */
        @Override
        public void addBringIn(BringIn bringIn) throws BringInException {
            if (bringIn == null) {
                throw new BringInException("添加招聘人员的参数有误");
            }

            try {
                int result = bringInDao.add(bringIn);

                if (result == 1) {
                    //添加成功
                } else if (result == 0) {
                    //id已存在
                    throw new BringInException("id已存在");
                } else {
                    //添加失败
                    throw new BringInException("添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
             throw new BringInException("添加失败", e);
            }
        }


        /**
     * way:delete
     *
     * @author Jessie
     * @param id
     * @throws BringInException
     * @since JDK 1.8
     */
        @Override
        public void deleteBringIn(Integer id) throws BringInException {
            if (id == null) {
                throw new BringInException("删除的参数有误");
            }

            try {
                int result = bringInDao.deleteById(id);
                if (result == 1) {
                    //删除成功
                } else {
                    //删除失败
                    throw new BringInException("删除失败");
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new BringInException("删除失败", e);
            }
        }

        /**
     * way:update
     *
     * @param bringIn
     * @throws BringInException
     * @author Jessie
     */
        @Override
        public void updateBringIn(BringIn bringIn) throws BringInException {

            if (bringIn == null) {
                throw new BringInException("修改招聘人员的参数有误");
            }

            try {
                int result = bringInDao.update(bringIn);

                if (result == 1) {
                    //修改成功
                } else {
                    //修改失败
                    throw new BringInException("修改失败");
                }
            } catch (BringInException e) {
                e.printStackTrace();
                throw new BringInException("修改失败", e);
            }
        }

}
