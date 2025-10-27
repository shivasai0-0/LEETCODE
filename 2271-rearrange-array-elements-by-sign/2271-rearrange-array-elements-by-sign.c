/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

int* rearrangeArray(int* nums, int numsSize, int* returnSize){
    int* res = (int*)malloc(numsSize * sizeof(int));
    int* pos = (int*)malloc(numsSize * sizeof(int));
    int* neg = (int*)malloc(numsSize * sizeof(int));
    int p = 0, n = 0;

    for(int i = 0; i < numsSize; i++){
        if(nums[i] > 0) pos[p++] = nums[i];
        else neg[n++] = nums[i];
    }

    int i = 0, pi = 0, ni = 0;
    while(i < numsSize){
        if(i % 2 == 0 && pi < p) res[i++] = pos[pi++];
        else if(ni < n) res[i++] = neg[ni++];
    }

    *returnSize = numsSize;
    free(pos);
    free(neg);
    return res;
}

