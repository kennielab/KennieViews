package com.kennie.example.library;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.dl7.tag.TagLayout;
import com.dl7.tag.TagView;
import com.kennie.example.library.utils.TagWordFactory;
import com.kennie.example.library.utils.ToastUtils;


public class TagShapeActivity extends AppCompatActivity implements TagView.OnTagClickListener, TagView.OnTagLongClickListener {

    private TagLayout mTagLayout1;
    private TagLayout mTagLayout2;
    private TagLayout mTagLayout3;
    private TagView mTagDel;
    private TagView mTagAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag_shape);
        initView();
    }

    private void initView() {
        mTagLayout1 = (TagLayout) findViewById(R.id.tag_layout_1);
        mTagLayout2 = (TagLayout) findViewById(R.id.tag_layout_2);
        mTagLayout3 = (TagLayout) findViewById(R.id.tag_layout_3);
        mTagDel = (TagView) findViewById(R.id.tag_del);
        mTagAdd = (TagView) findViewById(R.id.tag_add);
        mTagLayout1.setTagClickListener(this);
        mTagLayout1.setTagLongClickListener(this);
        mTagLayout2.setTagClickListener(this);
        mTagLayout2.setTagLongClickListener(this);
        mTagLayout3.setTagClickListener(this);
        mTagLayout3.setTagLongClickListener(this);

        mTagAdd.setTagClickListener(new TagView.OnTagClickListener() {
            @Override
            public void onTagClick(int position, String text, @TagView.TagMode int tagMode) {
                String word = TagWordFactory.provideTagWord();
                mTagLayout1.addTag(word);
                mTagLayout2.addTag(word);
                mTagLayout3.addTag(word);
            }
        });
        mTagDel.setTagClickListener(new TagView.OnTagClickListener() {
            @Override
            public void onTagClick(int position, String text, @TagView.TagMode int tagMode) {
                mTagLayout1.deleteTag(0);
                mTagLayout2.deleteTag(0);
                mTagLayout3.deleteTag(0);
            }
        });
    }

    @Override
    public void onTagClick(int position, String text, @TagView.TagMode int tagMode) {
        ToastUtils.showToast(text);
    }

    @Override
    public void onTagLongClick(int position, String text, @TagView.TagMode int tagMode) {
        ToastUtils.showToast("长按:" + text);
    }
}