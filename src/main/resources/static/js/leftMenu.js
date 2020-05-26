var student = JSON.parse(sessionStorage.getItem("student"));

var menuList =	[


    {
        id: '1',
        name: '用户管理',
        icon: 'el-icon-user',
        info: '对用户列表、添加、统计等等...',
        childList: [
            {
                id: '1-5',
                name: '新生添加',
                url: 'NSW-html/user/student-add.html'
            },
            {
                id:'1-4',
                name:'新生列表',
                url:'NSW-html/user/student-list.html'
            },
        ]
    },
    {
        id: '2',
        name: '班级管理',
        icon: 'el-icon-school',
        info: '对系统角色权限的分配等设计，敏感度较高，请谨慎授权',
        childList: [
            {
                id: '2-1',
                name: '班级列表',
                url: 'NSW-html/class-management/class-list.html'
            },

        ]
    },
    {
        id: '3',
        name: '宿舍管理',
        icon: 'el-icon-office-building',
        info: '对文章的增删改查、维护',
        childList: [
            {
                id: '3-1',
                name: '宿舍列表',
                url: 'NSW-html/dormitory-management/dormitory-List.html'
            },
        ]
    },
]

if(student!=null) {
    var studentType = [
        {
            id: '1',
            name: '个人信息',
            icon: 'el-icon-user',
            info: '注册步骤',
            url: "NSW-html/user/student-show.html?id=" + student.studentId
        },
        {
            id: '9',
            name: '线上缴费',
            icon: 'el-icon-coin',
            info: '注册步骤',
            url: "NSW-html/pay/pay.html"
        }
    ]


    var studentInfo0 = [
        {
            id: '8',
            name: '激活步骤',
            icon: 'el-icon-link',
            info: '注册步骤',
            url: "NSW-html/Steps/graduates.html"
        },

    ]


    var studentInfo1 = [
        {
            id: '8',
            name: '激活步骤',
            icon: 'el-icon-link',
            info: '注册步骤',
            url: "NSW-html/Steps/graduates.html"
        },

    ]
}