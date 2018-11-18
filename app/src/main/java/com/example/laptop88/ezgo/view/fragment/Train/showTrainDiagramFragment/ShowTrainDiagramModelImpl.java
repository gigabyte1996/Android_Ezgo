//package com.example.laptop88.ezgo.view.fragment.Train.showTrainDiagramFragment;
//
//import com.example.laptop88.ezgo.response.TrainDetailResponse;
//import com.example.laptop88.ezgo.response.TrainScheduleResponse;
//import com.example.laptop88.ezgo.service.ApplicationApi;
//import com.example.laptop88.ezgo.service.TrainApi;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class ShowTrainDiagramModelImpl implements ShowTrainDiagramModel {
//    private ShowTrainDiagramPresenter mShowTrainDiagramFragmentPresenter;
//    private ApplicationApi mApplicationApi;
//
//    public ShowTrainDiagramModelImpl(ShowTrainDiagramPresenter showTrainDiagramFragmentPresenter) {
//        if (mApplicationApi == null){
//            mApplicationApi = new ApplicationApi();
//        }
//        mShowTrainDiagramFragmentPresenter = showTrainDiagramFragmentPresenter;
//    }
//
//    @Override
//    public void getTrainDiagramByTrainID(String trainID) {
//        Call<TrainDetailResponse> call = mApplicationApi.getClient().create(TrainApi.class).getTrainDiagrambyTrainId(trainID);
//        call.enqueue(new Callback<TrainDetailResponse>() {
//            @Override
//            public void onResponse(Call<TrainDetailResponse> call, Response<TrainDetailResponse> response) {
////                TrainScheduleResponse trainScheduleResponse = response.body();
//                TrainDetailResponse trainDetailResponse = response.body();
//                int code = 0;
//                if (trainDetailResponse != null) {
//                    code = Integer.parseInt(trainDetailResponse.getError().getCode());
//                }
//                switch (code) {
//                    case 0:
//                        mShowTrainDiagramFragmentPresenter.getTrainDiagramByTrainIDSuccess(trainDetailResponse);
//
//                        break;
//                    default:
//                        mShowTrainDiagramFragmentPresenter.getTrainDiagramByTrainIDFail();
//                        break;
//                }
//            }
//
//            @Override
//            public void onFailure(Call<TrainDetailResponse> call, Throwable t) {
//                mShowTrainDiagramFragmentPresenter.getTrainDiagramByTrainIDFail();
//            }
//
//        });
//
//    }
//}
