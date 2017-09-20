package hfutonline.service;

import java.util.List;
import hfutonline.entity.BringIn;
import hfutonline.exception.BringInException;
/**
 * Created by lenovo on 2017/9/12.
 */
public interface BringInService {

    public List<BringIn> listAll() throws BringInException;

    public void addBringIn(BringIn bringIn) throws BringInException;

    public void deleteBringIn(Integer id) throws BringInException;

    public void updateBringIn(BringIn bringIn) throws BringInException;

    public List<BringIn> listBringInById(Integer id) throws BringInException;

    public Integer total()throws BringInException;

    public List<BringIn> page(Integer start,Integer count) throws BringInException;

}
