package test;

import com.jd.ccjf.common.Menu;
import com.jd.ccjf.common.tree.SimpleNode;
import com.jd.ccjf.common.tree.TreeUtil;
import com.jd.ccjf.master.condition.User.UserCondition;
import com.jd.ccjf.master.domain.Role;
import com.jd.ccjf.master.domain.User.User;
import com.jd.ccjf.master.service.MenuService;
import com.jd.ccjf.master.service.RoleService;
import com.jd.ccjf.master.service.UserService;
import com.jd.common.web.LoginContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


/**
 * 控制器
 *
 * @author zhuhua
 * @date 2014-12-08 11:51:33
 */
@Controller
public class MainsController {


    @Value("${logout.address}")
    private String logOutUrl;

    @Value("${webapp.domain.name}")
    private String returnUrl;

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private MenuService menuService;

    /**
     * 跳转到主页面
     *
     * @return
     */

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model, HttpServletResponse response) {
        String erpNumber = LoginContext.getLoginContext().getPin();
        model.addAttribute("erpNumber", erpNumber);
        model.addAttribute("logOutHref", logOutUrl+"?ReturnUrl="+returnUrl);
        return "main";
    }

    @RequestMapping(value = "/errorPage", method = RequestMethod.GET)
    public String errorPage(Model model, HttpServletResponse response) {
        String erpNumber = LoginContext.getLoginContext().getPin();
       // miniwmsSingleLoginUtil.logout(response);
        model.addAttribute("erpNumber", erpNumber);
        return "error";
    }

    private static LinkedList<SimpleNode> transSimpleNodes(List<com.jd.ccjf.master.domain.Menu> menus){
        LinkedList<SimpleNode> simpleNodes = new LinkedList<SimpleNode>();
        for(com.jd.ccjf.master.domain.Menu menu:menus){
            //SimpleNode simpleNode = new SimpleNode();
            String id = String.valueOf(menu.getId());
            String fid = String.valueOf(menu.getParentId());
            String name = menu.getMenuName();
            String url = menu.getMenuUrl();
            String icon = "icon-sys";
            SimpleNode simpleNode = new SimpleNode(id,fid,name,0,url,icon);
            simpleNodes.add(simpleNode);
        }
        return simpleNodes;
    }

    /*private static LinkedList<SimpleNode> transSimpleNodesTest(List<com.jd.ccjf.master.domain.Menu> menus){
        LinkedList<SimpleNode> simpleNodes = new LinkedList<SimpleNode>();
        SimpleNode simpleNode = new SimpleNode("1","0","基础资料",0,"-","icon-sys");
        SimpleNode simpleNode1 = new SimpleNode("2","0","计费数据",0,"-","icon-sys");
        SimpleNode simpleNode2 = new SimpleNode("3","0","权限管理",0,"-","icon-sys");
        SimpleNode simpleNode3 = new SimpleNode("4","0","考察设置",0,"-","icon-sys");

        SimpleNode simpleNode4 = new SimpleNode("5","2","计费提数",0,"ccjf_data/gotoCcjfDataPage.do","icon-sys");
        SimpleNode simpleNode5 = new SimpleNode("6","3","角色管理",0,"role/gotoRolePage.do","icon-sys");
        SimpleNode simpleNode6 = new SimpleNode("7","4","考察设置",0,"investigation/gotoInvestigationPage.do","icon-sys");
        SimpleNode simpleNode7 = new SimpleNode("8","4","考察设置1",0,"-","icon-sys");
        SimpleNode simpleNode8 = new SimpleNode("9","8","考察设置2",0,"-","icon-sys");
        SimpleNode simpleNode9 = new SimpleNode("10","3","菜单管理",0,"menu/gotoMenuPage.do","icon-sys");
        SimpleNode simpleNode10 = new SimpleNode("11","2","计费提数",0,"ccjf_data/gotoCcjfDataPage.do","icon-sys");
        SimpleNode simpleNode11 = new SimpleNode("12","2","计费提数",0,"ccjf_data/gotoCcjfDataPage.do","icon-sys");
        SimpleNode simpleNode12 = new SimpleNode("13","2","计费提数",0,"ccjf_data/gotoCcjfDataPage.do","icon-sys");
        SimpleNode simpleNode13 = new SimpleNode("14","2","计费提数",0,"ccjf_data/gotoCcjfDataPage.do","icon-sys");
        SimpleNode simpleNode14 = new SimpleNode("15","2","计费提数",0,"ccjf_data/gotoCcjfDataPage.do","icon-sys");
        SimpleNode simpleNode15 = new SimpleNode("16","2","计费提数",0,"ccjf_data/gotoCcjfDataPage.do","icon-sys");
        SimpleNode simpleNode16 = new SimpleNode("17","2","计费提数",0,"ccjf_data/gotoCcjfDataPage.do","icon-sys");
        SimpleNode simpleNode17 = new SimpleNode("18","2","计费提数",0,"ccjf_data/gotoCcjfDataPage.do","icon-sys");
        SimpleNode simpleNode18 = new SimpleNode("19","2","计费提数",0,"ccjf_data/gotoCcjfDataPage.do","icon-sys");

        SimpleNode simpleNode19 = new SimpleNode("20","0","基础资料",0,"-","icon-sys");
        SimpleNode simpleNode20 = new SimpleNode("21","0","计费数据",0,"-","icon-sys");
        SimpleNode simpleNode21 = new SimpleNode("22","0","权限管理",0,"-","icon-sys");
        SimpleNode simpleNode22 = new SimpleNode("23","0","考察设置",0,"-","icon-sys");
        SimpleNode simpleNode23 = new SimpleNode("24","0","基础资料",0,"-","icon-sys");
        SimpleNode simpleNode24 = new SimpleNode("25","0","计费数据",0,"-","icon-sys");
        SimpleNode simpleNode25 = new SimpleNode("26","0","权限管理",0,"-","icon-sys");
        SimpleNode simpleNode26 = new SimpleNode("27","0","考察设置",0,"-","icon-sys");
        simpleNodes.add(simpleNode);
        simpleNodes.add(simpleNode1);
        simpleNodes.add(simpleNode2);
        simpleNodes.add(simpleNode3);
        simpleNodes.add(simpleNode4);
        simpleNodes.add(simpleNode5);
        simpleNodes.add(simpleNode6);
        simpleNodes.add(simpleNode7);
        simpleNodes.add(simpleNode8);

        simpleNodes.add(simpleNode9);
        simpleNodes.add(simpleNode10);
        simpleNodes.add(simpleNode11);
        simpleNodes.add(simpleNode12);
        simpleNodes.add(simpleNode13);
        simpleNodes.add(simpleNode14);
        simpleNodes.add(simpleNode15);
        simpleNodes.add(simpleNode16);
        simpleNodes.add(simpleNode17);
        simpleNodes.add(simpleNode18);
        simpleNodes.add(simpleNode19);
        simpleNodes.add(simpleNode20);
        simpleNodes.add(simpleNode21);
        simpleNodes.add(simpleNode22);
        simpleNodes.add(simpleNode23);
        simpleNodes.add(simpleNode24);
        simpleNodes.add(simpleNode25);
        simpleNodes.add(simpleNode26);
        return simpleNodes;
    }*/

    /**
     * 主页面加载菜单
     *
     * @return
     */
    @RequestMapping(value = "/loadMenu.do", method = {RequestMethod.GET,
            RequestMethod.POST})
    public
    @ResponseBody
    Object loadMenu(Model model) {
        Map<String, List<Menu>> map = new HashMap<String, List<Menu>>();
        String loginuser = LoginContext.getLoginContext().getPin();
        UserCondition userCondition = new UserCondition();
        userCondition.setUserNo(loginuser);
        List<User> users = userService.queryUserList(userCondition);
        User user = users.get(0);
        Long userId = user.getId();
        List<Role> roles = roleService.queryRolesByUserId(userId);
        /*
        SELECT * FROM authority_menu WHERE id IN (
        SELECT menu_id FROM authority_role_menu_rel WHERE role_id IN (1) AND is_delete=1
        )
         */

        //List<com.jd.ccjf.master.domain.Menu> menus = new ArrayList<com.jd.ccjf.master.domain.Menu>();
        List<Byte> types = new ArrayList<Byte>();
        //type为资源类型，1为菜单，2为界面，3为按钮
        types.add((byte)1);
        types.add((byte)2);
        List<com.jd.ccjf.master.domain.Menu> menus = menuService.queryMenusByRoleIds(roles,types);
        //LinkedList<SimpleNode> simpleNodes = transSimpleNodesTest(menus);
//        com.jd.ccjf.master.domain.Menu menuTest=new com.jd.ccjf.master.domain.Menu();
//        menuTest.setMenuName("价目表定义");
//        menuTest.setMenuUrl("priceDefinition/gotoListPage.do");
//        menuTest.setSortNum(8);
//        menuTest.setParentId(153l);
//        menus.add(menuTest);
        LinkedList<SimpleNode> simpleNodes = transSimpleNodes(menus);

        SimpleNode root = new SimpleNode("0", null, "root", 0,"","");
        root = TreeUtil.getTree(root,simpleNodes);
        return root;

        /*
        List<Menu> list = new ArrayList<Menu>();

        //基础资料   ==》 基础资料
        List<Menu> listFirst = new ArrayList<Menu>();

        Menu menuFirst = new Menu();
        menuFirst.setMenus(listFirst);
        menuFirst.setName("基础资料");
        menuFirst.setIcon("icon-sys");

        list.add(menuFirst);

        //计费数据   ==》
        List<Menu> listSecond = new ArrayList<Menu>();

        Menu extractData = new Menu();
        extractData.setName("计费提数");
        extractData.setUrl("ccjf_data/gotoCcjfDataPage.do");
        extractData.setIcon("icon-sys");
        listSecond.add(extractData);


        Menu ccjfCheckHandle = new Menu();
        ccjfCheckHandle.setName("提数差异审核");
        ccjfCheckHandle.setUrl("diff_check/list.do");
        ccjfCheckHandle.setIcon("icon-sys");
        listSecond.add(ccjfCheckHandle);

        Menu monitorPourData = new Menu();
        monitorPourData.setName("灌数状态监控");
        monitorPourData.setUrl("task_result/list.do");
        monitorPourData.setIcon("icon-sys");
        listSecond.add(monitorPourData);

        Menu baseDataSync=new Menu();
        baseDataSync.setName("基础数据同步");
        baseDataSync.setUrl("datasync/list.do");
        baseDataSync.setIcon("icon-sys");
        listSecond.add(baseDataSync);

        Menu sellerInvestigateTask = new Menu();
        sellerInvestigateTask.setName("商家考察任务");
        sellerInvestigateTask.setUrl("CheckTaskController/gotocheckTaskListPage.do");
        sellerInvestigateTask.setIcon("icon-sys");
        listSecond.add(sellerInvestigateTask);

        Menu investigateResult = new Menu();
        investigateResult.setName("考察结果查看");
        investigateResult.setUrl("CheckResultController/gotocheckResultListPage.do");
        investigateResult.setIcon("icon-sys");
        //listSecond.add(investigateResult);

        Menu menuWorkerTime=new Menu();
        menuWorkerTime.setName("费用计算-时间");
        menuWorkerTime.setUrl("workerTime/list.do");
        menuWorkerTime.setIcon("icon-sys");
        listSecond.add(menuWorkerTime);

        Menu workTimerSeller = new Menu();
        workTimerSeller.setName("费用计算-商家");
        workTimerSeller.setUrl("workerTimeSellerController/gotoworkerTimeSellerPage.do");
        workTimerSeller.setIcon("icon-sys");
        listSecond.add(workTimerSeller);

        Menu ccjfExportHandle = new Menu();
        ccjfExportHandle.setName("计费明细导出");
        ccjfExportHandle.setUrl("exportData/index");
        ccjfExportHandle.setIcon("icon-sys");
        listSecond.add(ccjfExportHandle);

        Menu menuSecond = new Menu();
        menuSecond.setMenus(listSecond);
        menuSecond.setName("计费数据");
        menuSecond.setIcon("icon-sys");

        list.add(menuSecond);


        //权限管理
        List<Menu> listThird = new ArrayList<Menu>();


        Menu userManage = new Menu();
        userManage.setName("用户管理");
        userManage.setUrl("");
        userManage.setIcon("icon-sys");
        listThird.add(userManage);

        Menu roleManage = new Menu();
        roleManage.setName("角色管理");
        roleManage.setUrl("role/gotoRolePage.do");
        roleManage.setIcon("icon-sys");
        listThird.add(roleManage);

        Menu menu = new Menu();
        menu.setName("菜单管理");
        menu.setUrl("menu/gotoMenuPage.do");
        menu.setIcon("icon-sys");
        listThird.add(menu);

        Menu dataManage = new Menu();
        dataManage.setUrl("menu/gotoMenuPage.do");
        dataManage.setName("数据权限管理");
        dataManage.setIcon("icon-sys");
        listThird.add(dataManage);

        Menu menuThird = new Menu();
        menuThird.setMenus(listThird);
        menuThird.setName("权限管理");
        menuThird.setIcon("icon-sys");

        list.add(menuThird);

        //考察设置
        List<Menu> listFour = new ArrayList<Menu>();

        Menu investigateSetting = new Menu();
        investigateSetting.setName("考察设置");
        investigateSetting.setUrl("investigation/gotoInvestigationPage.do");
        investigateSetting.setIcon("icon-sys");
        listFour.add(investigateSetting);

        Menu mergeSubject = new Menu();
        mergeSubject.setName("合并主体设置");
        mergeSubject.setUrl("megerSubjectManager/gotoMegerSubjectBodyPage.do");
        mergeSubject.setIcon("icon-sys");
        listFour.add(mergeSubject);

        Menu mergeInvestigate = new Menu();
        mergeInvestigate.setName("促销合并考察");
        mergeInvestigate.setUrl("megerSubjectManager/gotoMegerSubjectDisCountPage.do");
        mergeInvestigate.setIcon("icon-sys");
        listFour.add(mergeInvestigate);

        Menu menuFour = new Menu();
        menuFour.setMenus(listFour);
        menuFour.setName("考察设置");
        menuFour.setIcon("icon-sys");

        list.add(menuFour);

        //仓储报价
        List<Menu> listFive = new ArrayList<Menu>();

        Menu standard = new Menu();
        standard.setName("标准报价");
        standard.setUrl("waresprice/gotoStandardPage");
        standard.setIcon("icon-price");
        listFive.add(standard);

        Menu seller = new Menu();
        seller.setName("商家报价");
        seller.setUrl("warespriceSeller/gotoSellerPage");
        seller.setIcon("icon-price");
        listFive.add(seller);


        Menu sku = new Menu();
        sku.setName("Sku报价");
        sku.setUrl("waresSku/gotoSkuPage");
        sku.setIcon("icon-price");
        listFive.add(sku);

        Menu goodsRemove = new Menu();
        goodsRemove.setName("不计入首件Sku设置");
        goodsRemove.setUrl("waresSku/gotoSkuRemovePage");
        goodsRemove.setIcon("icon-price");
        listFive.add(goodsRemove);

        Menu menuFive = new Menu();
        menuFive.setMenus(listFive);
        menuFive.setName("仓储报价");
        menuFive.setIcon("icon-sys");

        list.add(menuFive);

        //运输报价
        List<Menu> listSix = new ArrayList<Menu>();

        Menu transStandard = new Menu();
        transStandard.setName("标准运输报价");
        transStandard.setUrl("route/transStandardPriceSetting.do");
        transStandard.setIcon("icon-sys");
        listSix.add(transStandard);

        Menu sellerPrice = new Menu();
        sellerPrice.setName("商家运输报价");
        sellerPrice.setUrl("route/gotoSellerPricePage.do");
        sellerPrice.setIcon("icon-sys");
        listSix.add(sellerPrice);

        Menu menuSix = new Menu();
        menuSix.setMenus(listSix);
        menuSix.setName("运输报价");
        menuSix.setIcon("icon-sys");

        list.add(menuSix);

        //装卸报价
        List<Menu> listSeven = new ArrayList<Menu>();

        Menu newtranHandle = new Menu();
        newtranHandle.setName("标准装卸报价");
        newtranHandle.setUrl("newload/gotoTranLoadPage.do");
        newtranHandle.setIcon("icon-sys");
        listSeven.add(newtranHandle);

        Menu sellerLoadPrice = new Menu();
        sellerLoadPrice.setName("商家装卸报价");
        sellerLoadPrice.setUrl("seller/gotoSellerLoadPricePage.do");
        sellerLoadPrice.setIcon("icon-sys");
        listSeven.add(sellerLoadPrice);

        Menu menuSeven = new Menu();
        menuSeven.setMenus(listSeven);
        menuSeven.setName("装卸报价");
        menuSeven.setIcon("icon-sys");

        list.add(menuSeven);

        //促销体系
        List<Menu> listEight = new ArrayList<Menu>();

        Menu menuDiscount=new Menu();
        menuDiscount.setName("折扣促销");
        menuDiscount.setUrl("wares_discount/list.do");
        menuDiscount.setIcon("icon-sys");
        listEight.add(menuDiscount);

        Menu menuRebate=new Menu();
        menuRebate.setName("返利促销");
        menuRebate.setUrl("wares_rebate/list.do");
        menuRebate.setIcon("icon-sys");
        listEight.add(menuRebate);

        Menu menuOtherDiscount=new Menu();
        menuOtherDiscount.setName("其他促销");
        menuOtherDiscount.setUrl("other_discount/list.do");
        menuOtherDiscount.setIcon("icon-sys");
        listEight.add(menuOtherDiscount);

        Menu menuSellerDiscount=new Menu();
        menuSellerDiscount.setName("商家促销");
        menuSellerDiscount.setUrl("seller_discount/list.do");
        menuSellerDiscount.setIcon("icon-sys");
        listEight.add(menuSellerDiscount);

        Menu menuEight = new Menu();
        menuEight.setMenus(listEight);
        menuEight.setName("仓储促销");
        menuEight.setIcon("icon-sys");

        list.add(menuEight);

        //数据字典
        List<Menu> listNine = new ArrayList<Menu>();

        Menu prop = new Menu();
        prop.setName("基础属性");
        prop.setUrl("prop/gotoPropSetPage");
        prop.setIcon("icon-sys");
        listNine.add(prop);

        Menu menuNine = new Menu();
        menuNine.setMenus(listNine);
        menuNine.setName("数据字典");
        menuNine.setIcon("icon-sys");

        list.add(menuNine);

        //日常运维
        List<Menu> listTen = new ArrayList<Menu>();

        Menu propManage = new Menu();
        propManage.setName("数据库运维");
        propManage.setUrl("dataManager/gotoDataManagerPage.do");
        propManage.setIcon("icon-sys");
        listTen.add(propManage);

        Menu menuTen = new Menu();
        menuTen.setMenus(listTen);
        menuTen.setName("日常运维");
        menuTen.setIcon("icon-sys");

        list.add(menuTen);



        map.put("menus", list);
        return map;
        */
    }



}
