package hfutonline.controller;

import hfutonline.service.BringInService;
/**
 * Created by lenovo on 2017/9/12.
 *
 * @author Jessie
 *
 */

import hfutonline.entity.BringIn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.annotation.Resource;

import hfutonline.dto.Result;
import hfutonline.entity.BringIn;
import hfutonline.exception.BringInException;
import hfutonline.service.BringInService;

@Controller
public class BringInController {

    private static final Logger logger = LoggerFactory.getLogger(BringInController.class);

    @Resource
    private BringInService bringInService;


    /**
     * way:add
     *
     * @param bringIn
     * @return
     * @author:Jessie
     */
    @RequestMapping(value="/addBringInfo",method=RequestMethod.POST)
    @ResponseBody
    public Result<String> addBringIn(@RequestBody BringIn bringIn) {
        try {
            bringInService.addBringIn(bringIn);
        }catch (BringInException e){
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        logger.info("添加成功", bringIn);
        return new Result<String>(true, "提交成功", null);

    }

    /**
     * way:delete
     *
     * @param bringIn
     * @return
     * @author Jessie
     */
    @RequestMapping(value="/deleteBringInfo",method=RequestMethod.POST)
    @ResponseBody
    public Result<String> deleteBringIn(@RequestBody BringIn bringIn) {
        try{
            bringInService.deleteBringIn(bringIn.getId());
        }catch(BringInException e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        logger.info("删除成功",bringIn);
        return new Result<String>(true,"删除成功",null);
    }

    @RequestMapping(value = "/updateBringInfo",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> updateBringIn(@RequestBody BringIn bringIn){
        try{
            bringInService.updateBringIn(bringIn);
        }catch(BringInException e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        logger.info("修改成功",bringIn);
        return new Result<String>(true,"更新成功",null);
    }

    @RequestMapping(value="/listBringInById",method=RequestMethod.POST)
    @ResponseBody
    public Result<List<BringIn>> list(@RequestBody BringIn bringIn){
        try{
            List<BringIn> listBringInById=bringInService.listBringInById(bringIn.getId());
            logger.info("根据id查找成功",listBringInById);
            return new Result<List<BringIn>>(true,"根据id查找成功",listBringInById);
        }catch(BringInException e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
            return new Result<List<BringIn>>(false,e.getMessage(),null);
        }
    }

    @RequestMapping(value = "/bringIn/list", method = RequestMethod.POST)
    @ResponseBody
    public Result<List<BringIn>> list() {
        System.out.println("cfvgbhjnmk");
        try {
            List<BringIn> list = bringInService.listAll();
            logger.info("获取新闻列表成功", list);
            System.out.println(list.get(1).getName());
            return new Result<List<BringIn>>(true, "获取招聘人员列表成功", list);
        } catch (BringInException e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            return new Result<List<BringIn>>(false, e.getMessage(), null);
        }
    }

   /* @RequestMapping(value="/bringIn/page",method = RequestMethod.POST)
    @ResponseBody
    public Result<List<BringIn>> listPage(@RequestBody Page page){
        Integer start=0;
        try{
            try {
                start = Integer.parseInt();
            } catch (NumberFormatException e) {
                // 当浏览器没有传参数start时
            }
            List<BringIn> listPage=bringInService.page(start,10);
            logger.info("分页成功",listPage);
            return new Result<List<BringIn>>(true,"分页成功",listPage);
        }catch (BringInException e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
            return new Result<List<BringIn>>(false,e.getMessage(),null);
        }
    }*/

    @RequestMapping(value="/bringIn/total",method = RequestMethod.POST)
    @ResponseBody
    public Integer total(){
        Integer total;
        try{
            total=bringInService.total();
            logger.info("计算总数成功",total);
            return total;
        }catch (BringInException e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
            return 0;
        }
    }

}
