<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="row-fluid">
    <div class="span12">
        <div class="tab" id="tab">
            <div class="tab-nav j-tab-nav">
                <a href="javascript:void(0);" class="current">Tab1</a>
                <a href="javascript:void(0);">Tab2</a>
                <a href="javascript:void(0);">Tab3</a>
                <a href="javascript:void(0);">Tab4</a>
                <a href="javascript:void(0);">Tab5</a>
            </div>
            <div class="tab-con">
                <div class="j-tab-con">
                    <div class="tab-con-item" style="display:block;">
                        111111
                    </div>
                    <div class="tab-con-item">
                        222222
                    </div>
                    <div class="tab-con-item">
                        333333
                    </div>
                    <div class="tab-con-item">
                        444444
                    </div>
                    <div class="tab-con-item">
                        555555
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript" src="media/js/jQuery.rTabs.js"></script>
<script type="text/javascript">
    $(function() {
        $("#tab").rTabs();
    })
</script>
<style>
    body{ background:#fff;}
    .tab {
        /*width: 80%; height: 90px; min-width: 300px;*/
        position: relative;
        width: 100%;
        height: 100%;
        min-width:480px;
        overflow: hidden;
        margin-top: 20px;
        font-family: Arial;
    }
    .tab-nav {
        height: 30px;
        overflow: hidden;
        background: #f5f5f5;
    }
    .tab-nav a {
        display: block;
        float: left;
        width: 80px;
        height: 30px;
        line-height: 30px;
        text-align: center;
        text-decoration: none;
        color: #999;
    }
    .tab-nav a.current {
        background: #80b600;
        color: #fff;
    }
    .tab-con {
        position: relative;
        width: 100%;
        height: 100%;
        min-width:480px;
        overflow: hidden;
        background: #adb65c;
    }
    .tab-con-item {
        display: none;
        width: 100%;
        height: 100%;
        min-width:480px;
        min-height:800px;
        text-align: center;
        color: #fff;
    }
</style>




