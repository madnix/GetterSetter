var visual_img = null;
$(document).ready(function(){
	/* 메인 이미지 롤링 */
	 visual_Rolling = {
		index : 0 ,
		imgArr : $('img[id^=visual_Img]'),
		number : $('img[id^=visual_Number]'),
		start : function(mode){
			if(this.thread!=null)clearInterval(this.thread);
			tt = setTimeout(function(){
				visual_Rolling.view(visual_Rolling.index,mode)
			},0);	
			this.thread = setInterval(function(){visual_Rolling.view(visual_Rolling.index,mode);},5000);
		},
		stop : function(index){
			clearInterval(this.thread);
			this.view(index,false);
		},
		view : function(index,mode){
			this.index = index;
			if(mode=='+'){
				if(++this.index == this.imgArr.length)this.index=0;
			}else if(mode=='-'){
				if(--this.index < 0)this.index = this.imgArr.length -1;
			}
			this.imgArr.fadeOut(800);
			$(this.imgArr[this.index]).fadeIn(800);
			this.number.each(function(val){
				if(visual_Rolling.index==val)this.src = getOnImageName(this);
				else this.src = getImageName(this);
			});
		},
		thread : null
	};

	 visual_Rolling.start('+');

});


