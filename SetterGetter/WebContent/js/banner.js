var banner = null;

$(document).ready(function(){
	banner = new js_rolling('banner');
	banner.set_direction(4);
	banner.move_gap = 1;
	banner.time_dealy = 20;
	banner.time_dealy_pause = 2000;
	banner.start();
	
});
	
var js_rolling = function(bannerContainer){
	// 시간단위는 ms로 1000이 1초
	if(bannerContainer.nodeType==1){
		this.bannerContainer = bannerContainer;
	}else{
		this.bannerContainer = document.getElementById(bannerContainer);
	}
	this.is_rolling = false;
	this.direction = 1; //1:top, 2:right, 3:bottom, 4:left (시계방향) // 1번과 4번만 됨
	this.children = null;
	this.move_gap = 1; //움직이는 픽셀단위
	this.time_dealy = 20; //움직이는 타임딜레이
	this.time_dealy_pause = 2000;//하나의 대상이 새로 시작할 때 멈추는 시간, 0 이면 적용 안함
	this.time_timer=null;
	this.time_timer_pause=null;
	this.mouseover=false;
	this.user_stop=false;
	this.init();
	this.set_direction(this.direction);
};

js_rolling.prototype.init = function(){
	this.bannerContainer.style.position='relative';
	this.bannerContainer.style.overflow='hidden';
	
	var children = this.bannerContainer.childNodes;
	
	for(var i=(children.length-1);0<=i;i--){
		if(children[i].nodeType==1){
			children[i].style.position='relative';
			children[i].style.padding='0 10px';
			
		}else{
			this.bannerContainer.removeChild(children[i]);
			
		}
	}
	var bannerContainer=this;
	this.bannerContainer.onmouseover=function(){
		bannerContainer.mouseover=true;
		if(!bannerContainer.time_timer_pause && !bannerContainer.user_stop){
			bannerContainer.pause();
		}
	};
	this.bannerContainer.onmouseout=function(){
		bannerContainer.mouseover=false;
		if(!bannerContainer.time_timer_pause && !bannerContainer.user_stop){
			bannerContainer.resume();
		}
	};
	/*
	this.bannerContainer.onfocus=function(){
		bannerContainer.mouseover=true;
		if(!bannerContainer.time_timer_pause){
			bannerContainer.pause();
		}
	}
	this.bannerContainer.onblur=function(){
		bannerContainer.mouseover=false;
		if(!bannerContainer.time_timer_pause){
			bannerContainer.resume();
		}
	}
	*/
};

js_rolling.prototype.set_direction = function(direction){
	this.direction=direction;
	if(this.direction==2 ||this.direction==4){
		this.bannerContainer.style.whiteSpace='nowrap';
	}else{
		this.bannerContainer.style.whiteSpace='normal';
	}
	var children = this.bannerContainer.childNodes;
	for(var i=(children.length-1);0<=i;i--){
		if(this.direction==1){
			children[i].style.display='block';
		}else if(this.direction==2){
			children[i].style.textlign='right';
			children[i].style.display='inline';
		}else if(this.direction==3){
			children[i].style.display='block';
		}else if(this.direction==4){
			children[i].style.display='inline';
		}
	}
	this.init_element_children(); 
};

js_rolling.prototype.init_element_children = function(){
	var children = this.bannerContainer.childNodes;
	this.children = children;
	for(var i=(children.length-1);0<=i;i--){
		
		if(this.direction==1){
			children[i].style.top='0px';
		}else if(this.direction==2){
			children[i].style.left='-'+this.bannerContainer.firstChild.offsetWidth+'px';
		}else if(this.direction==3){
			children[i].style.top='-'+this.bannerContainer.firstChild.offsetHeight+'px';
		}else if(this.direction==4){
			children[i].style.left='0px';
		}
	}
};

js_rolling.prototype.act_move_up = function(){
	for(var i=0, m=this.children.length; i<m; i++){
		var child = this.children[i];
		child.style.top=(parseInt(child.style.top)-this.move_gap)+'px';
	}
	if((this.children[0].offsetHeight+parseInt(this.children[0].style.top))<=0){
		this.bannerContainer.appendChild(this.children[0]);
		this.init_element_children();
		this.pause_act();  
	}
};

js_rolling.prototype.move_up = function(){
	if(this.direction!=1&&this.direction!=3){return false;}
	this.bannerContainer.appendChild(this.children[0]);
	this.init_element_children();
	this.pause_act(); 
};

js_rolling.prototype.act_move_down = function(){
	for(var i=0, m=this.children.length; i<m; i++){
		var child = this.children[i];
		child.style.top=(parseInt(child.style.top)+this.move_gap)+'px';
	}
	if(parseInt(this.children[0].style.top)>=0){
		this.bannerContainer.insertBefore(this.bannerContainer.lastChild,this.bannerContainer.firstChild);
		this.init_element_children();
		this.pause_act(); 
	}
};

js_rolling.prototype.move_down = function(){
	if(this.direction!=1&&this.direction!=3){return false;} 
	this.bannerContainer.insertBefore(this.bannerContainer.lastChild,this.bannerContainer.firstChild);
	this.init_element_children();
	this.pause_act();
};

js_rolling.prototype.act_move_left = function(){
	for(var i = 0,m=this.children.length;i<m;i++){
		var child = this.children[i];
		child.style.left=(parseInt(child.style.left)-this.move_gap)+'px';
	}
	if((this.children[0].offsetWidth+parseInt(this.children[0].style.left))<=0){
		this.bannerContainer.appendChild(this.bannerContainer.firstChild);
		this.init_element_children();
		this.pause_act();  
	}
};

js_rolling.prototype.move_left = function(){
	if(this.direction!=2&&this.direction!=4){return false;}  
	this.bannerContainer.appendChild(this.bannerContainer.firstChild);
	this.init_element_children();
	this.pause_act();  
};

js_rolling.prototype.act_move_right = function(){
	for(var i = 0,m=this.children.length;i<m;i++){
		var child = this.children[i];
		child.style.left=(parseInt(child.style.left)+this.move_gap)+'px';
	}

	if(parseInt(this.bannerContainer.lastChild.style.left)>=0){
		this.bannerContainer.insertBefore(this.bannerContainer.lastChild,this.bannerContainer.firstChild);
		this.init_element_children();
		this.pause_act();  
	}
};

js_rolling.prototype.move_right = function(){
	if(this.direction!=2&&this.direction!=4){return false;}   
	this.bannerContainer.insertBefore(this.bannerContainer.lastChild,this.bannerContainer.firstChild);
	this.init_element_children();
	this.pause_act();
};

js_rolling.prototype.start = function(){ //롤링 시작
	var bannerContainer = this;
	this.stop();
	this.is_rolling = true;
	var act = function(){
		if(bannerContainer.is_rolling){
			if(bannerContainer.direction==1){bannerContainer.act_move_up();}
			else if(bannerContainer.direction==2){bannerContainer.act_move_right();}
			else if(bannerContainer.direction==3){bannerContainer.act_move_down();}
			else if(bannerContainer.direction==4){bannerContainer.act_move_left();}
		}
	};
	this.time_timer = setInterval(act,this.time_dealy);
};

js_rolling.prototype.pause_act = function(){ //일시 동작
	if(this.time_dealy_pause){
		var bannerContainer = this;
		var act = function(){bannerContainer.resume();bannerContainer.time_timer_pause=null;};
		if(this.time_timer_pause){clearTimeout(this.time_timer_pause);}
		this.time_timer_pause = setTimeout(act,this.time_dealy_pause);
		this.pause();
	}
};

js_rolling.prototype.pause = function(){ //일시 멈춤
	this.is_rolling = false;
};

js_rolling.prototype.resume = function(){ //일시 멈춤 해제
	if(!this.mouseover && !this.user_stop){
		this.is_rolling = true;
	}
};

js_rolling.prototype.stop = function(){ //롤링을 끝냄
	this.is_rolling = false;
	if(!this.time_timer){
		clearInterval(this.time_timer);
	}
	this.time_timer = null;
};
	
js_rolling.prototype.user_pause = function(){ //일시 멈춤
	this.user_stop = true;
	this.pause();
};

js_rolling.prototype.user_resume = function(){ //일시 멈춤 해제
	this.user_stop = false;
	this.resume();
};